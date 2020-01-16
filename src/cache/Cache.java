/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author pedago
 */
public class Cache {

    public final int TAILLE_BLOC = 32 ;
    public static int N = 4;
    public static int NB_LIGNE = (int) pow(2,N);
    public static int BITS_DEPLACEMENT = 5 ;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        int cache[] = new int[NB_LIGNE];
        boolean Visite[] = new boolean[cache.length];
        int echecs = 0 ;
        int succes = 0;
        int tmp_exe = 0;
        try (FileReader fileReader = new FileReader("alea10.txt");
                Scanner scanner =new Scanner(fileReader)){
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] line = s.split(":"); 
                int value = Integer.parseInt(line[0]);
                
                //int deplacement = (int) (value % pow(2,BITS_DEPLACEMENT) );
                int reste = (int) (value / pow(2,BITS_DEPLACEMENT));
                int numLigne = (int) (reste % pow(2,N));
                int etiquette = (int) (reste / pow(2,N));
                //System.out.println(etiquette+" " +numLigne+" "+deplacement);
                
                if (Visite[numLigne]==false || cache[numLigne]!=etiquette){
                    Visite[numLigne]=true;
                    echecs++;
                    tmp_exe +=50;
                    cache[numLigne]=etiquette;
                }
                else{
                    succes++;  
                    tmp_exe+=5;
                    }
                }
            System.out.println("nb echecs = "+echecs);
            System.out.println("nb succes = "+succes);
            System.out.println("temps moyen d'execution (en ns) " + tmp_exe);
                    
            }
        }
    }
    
}
