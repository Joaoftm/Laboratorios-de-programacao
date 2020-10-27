import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author João Miranda 
 * @date 18 Maio 2018
 *
 *
 * OBSERVACAO : Todos os metodos nao passaram nos testes todos, fallhando sempre o teste de "naoSerX"
 */
public class Padroes {

	/**
	 * EX1 - multibancos
	 * @param texto
	 * @return
	 */
	public int multibanco (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("\\d{4}");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}

	/**
	 * EX2 - telefones tugas
	 * @param texto
	 * @return
	 */
	public int telefonePorugues (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("(((00351))\\d{9})|([+]351\\d{9})");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}

	/**
	 * EX3 - telemoveis tuga
	 * @param texto
	 * @return
	 */
	public int telemoveisPortugueses (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("(((91))\\d{7}|((92))\\d{7}|((93))\\d{7}|((96))\\d{7})");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;

	}


	/**
	 * EX4 - nome com apelido
	 * @param texto
	 * @return
	 */
	public int nomeComApelido (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("((([A-Z]))\\w{2,}\\s|(([A-Z]))\\w{2,}|)?");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;



	}

	/**
	 * EX5 - ficheiro zip ou rar
	 * @param texto
	 * @return
	 */
	public int ficheiroZipOuRar (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("(\\w{1,}[.](zip))|\\w{1,}[.](rar)");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;


	}    


	/**
	 * EX6 - variavel Java
	 * @param texto
	 * @return
	 */
	public int variavelJava (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("(([a-z0-9]{1,}[A-Z][a-z0-9]){1,})|([a-z]{1,})");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;

	}    

	/**
	 * EX7 - classe Java
	 * @param texto
	 * @return
	 */
	public int classeJava (String texto) {


		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("(([A-Z][a-z0-9]){1,})");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}

	/**
	 * EX8 - comentario simples java
	 * @param texto
	 * @return
	 */
	public int comentarioSimplesJava (String texto) {


		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("//(\\w{1,})|//\\s(\\w{1,})//\\s|((\\w{1,}\\s)|(\\w{1,}))");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}

	/**
	 * EX9 - operador aritmetico em java
	 * @param texto
	 * @return
	 */
	public int operadorAritmeticoJava (String texto) {


		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("[+]|-|[*]|");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}

	/**
	 * EX10 - operador logico em java
	 * @param texto
	 * @return
	 */
	public int operadorLogicoJava (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("&&|(\\|\\|)");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;

	}   


	/**
	 * EX11 - endereco IP
	 * @param texto
	 * @return
	 */
	public int enderecoIP (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("\\d{1,}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}   


	/**
	 * EX12 - credencial aluno FCUL
	 * @param texto
	 * @return
	 */
	public int credencialAlunoFcul (String texto) {

		Scanner sc = new Scanner(texto);
		Pattern pattern = Pattern.compile("fc\\d{5}");
		Matcher match ;
		int n = 0;

		while(sc.hasNextLine()){

			match = pattern.matcher(sc.nextLine());

			if(match.find()){
				n++;
			}
		}

		sc.close();
		return n;
	}   

	/**
	 * EX13 - data
	 * @param texto
	 * @return
	 */
	public int data (String texto) {

		Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		Matcher match = pattern.matcher(texto);
		int n = 0;

		while(match.find()){

			n++;
		}

		return n;
	}   


	/**
	 * EX14 - matricula portuguesa
	 * @param texto
	 * @return
	 */
	public int matricula (String texto) {

		Pattern pattern = Pattern.compile("(([A-Z]){2}-([A-Z]){2}-([0-9]){2}-([A-Z]){2}-([A-Z]){2})");
		Matcher match = pattern.matcher(texto);
		int n = 0;

		while(match.find()){

			n++;
		}

		return n;
	}   


	/**
	 * EX15 - matricula portuguesa
	 * @param texto
	 * @return
	 */
	public int euroOuDolar (String texto) {

		Pattern pattern = Pattern.compile("\\s{1,}([.]\\d{2})?€|\\$\\d{1,}([.]\\d|([A-Z]){2}-([A-Z]){2}");
		Matcher match = pattern.matcher(texto);
		int n = 0;

		while(match.find()){

			n++;
		}

		return n;
	}   

	/**
	 * EX16 - email
	 * @param texto
	 * @return
	 */
	public int email (String texto) {

		Pattern pattern = Pattern.compile("\\w{1,}@\\w{1,}[.]\\w{1,3}([.]\\w{1,3})?");
		Matcher match = pattern.matcher(texto);
		int n = 0;

		while(match.find()){

			n++;
		}

		return n;
	}   



}
