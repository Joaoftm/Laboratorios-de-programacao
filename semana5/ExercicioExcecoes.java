
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Joao Miranda; 
 * @date 8 Abril 2018
 *
 */
public class ExercicioExcecoes {

	/**
	 * Le vector de inteiros e uma potencia e imprime os valores das 
	 * potencias dos inteiros
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {

		try( Scanner sc = new Scanner(new File(args[0]))){
			int tamanho  = lerTamanhoVector(sc);
			int[] inteiros  = leInteirosVector(sc,tamanho);
			double potencia = lerValorPotencia(sc);
			double[] raizes = calculaPotencias(inteiros, potencia);
			imprimeVector(raizes);

		} catch(ArrayIndexOutOfBoundsException e){

			System.out.println("algo nao esta bem com o array");

		} catch(IllegalArgumentException e ){

			System.out.println("valor da potencia eh negativo");

		} catch(InputMismatchException e){

			System.out.println("Formato errado");

		} catch(FileNotFoundException e){

			System.out.println("ficheiro nao existe");
		}
	}






	/**
	 * Le o tamanho do vector original
	 * @param sc - o scanner usado para a leitura
	 * @return o tamanho do vector a ler
	 * @requires sc != null
	 */
	public static int lerTamanhoVector(Scanner sc) {

		int a = 0;
		int b = sc.nextInt();

		if( a < b){

			throw new InputMismatchException("A primeira linha não é inteiro positivo");
		}

		return Integer.parseInt(sc.nextLine());
	}

	/**
	 * Le para um vector de inteiros os seus valores
	 * @param sc - o scanner usado para a leitura
	 * @param tamanho - o valor que eh suposto o vector ter
	 * @return o vector de inteiros obtidos da leitura
	 * @requires tamanho > 0
	 */
	public static int[] leInteirosVector(Scanner sc, int tamanho) {


		int [] a = new int [tamanho];

		if(a.length != tamanho){

			throw new InputMismatchException("tamanho do vetor nao eh igual");
		}

		return null;
	} 

	/**
	 * Leitura do valor de potencia
	 * @param sc o scanner de onde obter os valores
	 * @return a potencia
	 * @requires sc != null
	 */
	public static double lerValorPotencia(Scanner sc) {
		return Double.parseDouble(sc.nextLine());
	}

	/**
	 * Determina as potencias dos elementos de um vector
	 * @param inteiros - o vector original
	 * @param potencia - a potencia que se pretende calcular do vector de inteiros
	 * @return o vector com o calculo das potencias de inteiros
	 * @requires potencia >= 0, inteiros != null
	 */
	private static double[] calculaPotencias(int[] inteiros, double potencia) {
		double[] a = new double[inteiros.length];

		try{	


			for( int i =0;i < inteiros.length;i++){
				a[i]=inteiros[i]*potencia;
			}



		}catch(ArithmeticException e){

			System.out.println("Tentou calcular a potencia de um valor negativo");

		}
		return a;
	}

	/**
	 * Imprime os valores de um vectos de doubles
	 * @param raizes - o vector do qual se quer imprimir os valores
	 * @requires raizes != null
	 */
	private static void imprimeVector(double[] raizes) {
		for (double d : raizes) {
			System.out.print(d + " ");
		}
		System.out.println();
	}

}
