
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ExemploFicheiros {

    private static final int DEZ =10;

    public static void copiaTexto (String fileIn, String fileOut) throws FileNotFoundException {
        Scanner in = new Scanner (new File(fileIn));
        PrintWriter out = new PrintWriter(fileOut);
        boolean novaLinha = in.hasNext();
        // enquanto o ficheiro nao terminar 
        while (novaLinha){
            out.println(in.nextLine());
            novaLinha = in.hasNext();
        }

        in.close();
        out.close();
    }


    /**
     * faz a copia de um texto colocando tudo em minusculas
     * @param in - de onde ler os valores
     * @param out - o que escrever
     * @throws FileNotFoundException 
     * @requires in, out != null
     */
    public static void tudoMinusculas (String fileIn, String fileOut) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileIn));
        PrintWriter out = new PrintWriter(fileOut);
        while(in.hasNextLine()){
            String line = in.nextLine();
            out.println(line.toLowerCase());
        }
        
        in.close();
        out.close();
    }

    /**
     * regista os de in em out
     * @param in
     * @param out
     * @requires in!=null && out != null e in so com numeros  
     */
    public static void guardaPares (String filein, String fileout) throws FileNotFoundException {
        Scanner in = new Scanner (new File(filein));
        PrintWriter out = new PrintWriter(fileout);
        // enquanto o ficheiro nao terminar
        while (in.hasNextInt()){    
            int valorobtido = in.nextInt();
            Calculadora aminhacalculadora = new Calculadora(valorobtido);
            aminhacalculadora.ehpar(valorobtido);
            if (aminhacalculadora.ehpar(valorobtido)) {
                out.println(valorobtido);
            }
        }
        in.close();
        out.close();
    }

    /**
     * regista o dobro de cada numero em in em out
     * @param in
     * @param out
     * @requires in!=null && out != null e in so com numeros  
     */
    public static void calculaDobro (String fileIn ,String fileOut) throws FileNotFoundException {
       
        Scanner in = new Scanner (new File(fileIn));
        PrintWriter out = new PrintWriter(fileOut);
       
        while (in.hasNext() ){
          //  calculadora aminhacalculadora = new calculadora();
            int valor = in.nextInt();
            Calculadora aminhacalculadora = new Calculadora(valor);
            System.out.println(aminhacalculadora.dobro(valor));
            //out.println(aminhacalculadora.dobro(valor));
           
            
        }
        in.close();
        out.close();
    }


    /**
     * calculo no numero de vezes que aparecem 1, 10, ..., 10^n
     * @param in - de onde ler os valores
     * @param out - o que escrever
     * @param n
     * @requires in, out != null, in so com inteiros.
     */
    public static void potenciasDe10 (String fileIn, String fileOut, int n) throws FileNotFoundException{
        Scanner in = new Scanner (new File(fileIn));
        PrintWriter out = new PrintWriter(fileOut);
        int[] potencias = new int[n+1];
        while(in.hasNextInt()){
            int valor = in.nextInt();
            Calculadora.ehPotenciaDe10(potencias, valor);
        }

        //agora coloco os valor no ficheiro!
        for (int i = potencias.length; i < potencias.length; i++) {
            out.println(potencias[i]);
        }
        
        in.close();
        out.close();
    }

    /**
     * Calcula o arredondamento dado um algarismo para a dezena mais proxima 
     * @param algarismo - representacao de um algarismo em String
     * @return 0 se 0 <= algarismo < 5 e 10 caso contrario
     * @requires 0 <= algarismo < 10
     */
    public static int metodo(String algarismo) {
       
        if(algarismo.equals ("2") || algarismo.equals( "0") || algarismo.equals( "1") ){
            return 0;
        }
        if(algarismo.equals( "5")||algarismo.equals( "6")||algarismo.equals( "7")){
            return DEZ;
        }
        
        if(algarismo.equals( "8")|| algarismo.equals( "9")){
            return DEZ;
        }
      
        
        return 0;
        
    }


}
