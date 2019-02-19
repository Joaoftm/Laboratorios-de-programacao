

 *
 */
public class Recursive {

    public static double potencia (double base, int expoente) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Metodo que calcula a soma de todos os numeros nao negativos ate n
     * 
     * @param n numero pelo qual vamos vamos parar de calcular a soma
     * @return valor da soma
     * @requires n <=0
     */
    public static int soma (int n) {

        if( n==1 ){

            return 1;
        }

        if( n==0 ){

            return 0;

        }
        else if( n%2==0 ){

            return n +soma(n-1);

        }
        else{

            return soma(n-1);

        }

    }

    public static int maior (int[] v) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Metodo que calcula o numero de vezes q c aparece na string s 
     * 
     * @param s string com o texto/frase a analisar
     * @param c char pelo qual vamos procurar na string
     * @return numero de ocorrencias que c aparece em s
     * @requires string nao vazia
     */
    public static int countChar (String s, char c) {

        return countCharAUX(s,c,0);
    }

    /**
     * Metodo auxiliar que permite calcular o numero de vezes q c aparece na string s
     * 
     * @param s string com o texto/frase a analisar
     * @param c char pelo qual vamos procurar na string
     * @param i inteiro que representar o meu inicio da string( como um index)
     * @return numero de ocorrencias q c aperece em s
     */
    private static int countCharAUX(String s, char c, int i) {

        if(i==s.length()){
            return 0;
        }else if(s.charAt(i)==c){
            return 1 + countCharAUX(s,c,i+1);
        }else{
            return countCharAUX(s,c,i+1);
        }

    }

    public static String change (String s, char old, char newer) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Metodo que representa o algoritmo de Euclides ( maximo divisor entre dois numeros)
     * 
     * @param p inteiro para o calculo do maximo divisor comum
     * @param q inteiro para o calculo do maximo divisor comum
     * @return maximo divisor comum entre p e q
     * @requires p>=0 ; p>=0
     */
    public static int gcd (int p, int q) {

        if(q==0){

            return p;

        }
        if(p>=q){
            return gcd(q,p%q);

        }
        else{

            return q%p;

        }

    }

    /**
     * Metodo que me calcula as combinacoes de k a k 
     * 
     * @param l inteiro para calcular a combinacao
     * @param k inteiro para calcular a combinacao
     * @return inteiro que representa o valor da combinacao
     * @requires l e k >=0
     */
    public static int binomial (int l, int k) {

        if(l==k){
            return 1;
        }
        if(k>l || l==0){
            return 0;
        }
        else{
            return binomial(l-1,k)+ binomial(l-1,k-1);
        }

    }

    public static boolean pertence (int[] v, int n) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean ehSimetrico (int[] v) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Metodo que verifica se um vetor de double esta ordenado
     * 
     * @param v vetor de double a analisar
     * @return boolean consoante o resultado, se o vetor esta ordenado ou nao
     * @requires v.lenght >= 0
     */
    public static boolean ehCrescente (double[] v) {

        return ehCrescenteAUX(v,0);
    }

    /**
     * Metodo auxiliar que me verifica se um vetor de double esta ordenado
     * 
     * @param v vetor de double a analisar
     * @param i inteiro que me representa o indice a andar
     * @return boolean consoante o vetor esta organizado ou nao
     * @requires v.lenght >=0 ; i>=0
     */
    private static boolean ehCrescenteAUX(double[] v, int i) {

        if(i==v.length-1){

            return true;

        }
        if(v[i]<=v[i+1]){

            return ehCrescenteAUX(v,i+1);

        }
        return false;
    }

    public static String intToBin (int n) {
        // TODO Auto-generated method stub
        return null;
    }

    public static int triangulos (int l) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int numeroOrelhas (int l) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int algarismos (int l) {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * Metodo que me calcula a soma dos Algarismos ate l
     * 
     * @param l inteiro pelo qual vamos calcular os algarismos( ate esse l )
     * @return valor da soma dos algarismos ate l
     * @requires l>=0
     */
    public static int somaAlgarismos (int l) {
        int soma = 0;

        if(l==0){

            return soma;

        }

        soma = l%10+somaAlgarismos(l/10);

        return soma;
    }

    public static boolean ehPrimo (int n) {
        // TODO Auto-generated method stub
        return false;
    }

    public static int produto (int n, int m) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int somaQuadrados (int n) {
        // TODO Auto-generated method stub
        return 0;
    }
}
