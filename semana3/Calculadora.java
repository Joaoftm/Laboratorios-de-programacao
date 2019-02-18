

public class Calculadora {
    //o valor do numero Pi
    private static final double PI = 3.14; 
    private int numerodecalculos;
    private static final int DEZ =10;
    private static final int DOIS=2;

    Calculadora(int numerodecalculos){

        this.numerodecalculos=numerodecalculos;
    }

    public boolean ehpar (int valor) {
        this.numerodecalculos++;

        return valor%DOIS==0;
    }

    public  double numeroPi() {

        return PI;
    }

    public int numeroCalculos() {
        return numerodecalculos;
    }

    public int dobro (int valor) {
        this.numerodecalculos++;
        return DOIS * valor;

    }

    public static  void ehPotenciaDe10 (int[] potencias, int valor) {
        int power10 = 1;

        for (int i = 0; i < potencias.length; i++) {
            if(power10 == valor){
                potencias[i]++;
            }else{

                power10 *= DEZ;
            }
            System.out.println("Linha com problemas por ser muito grande");
        }
    }

}
