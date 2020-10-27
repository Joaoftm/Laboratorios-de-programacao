import java.util.Iterator;
import java.util.Scanner;

/**
 * Classe Rede
 * @author Joao Miranda 
 * @date 4/maio/2018
 *
 */
public class Rede {


	private int raio;
	private LinkedBinaryTree<Character> arvore;
	private ArrayQueue<Character> reservas;

	/**
	 * Constroi uma rede de exploracao dado a configuracao num ficheiro
	 * @param ficheiro - o scanner com o conteudo do ficheiro
	 */
	public Rede(Scanner ficheiro) {


		arvore = LeitorDeArvore.leArvore(ficheiro);
		this.raio = arvore.height();
		this.reservas = new ArrayQueue<>();

	}


	@Override
	/**
	 * Esta rede eh iguala a um dado obecto?
	 * param obj - o outro objecto
	 */
	public boolean equals(Object obj) {

		if(this == obj){

			return true;
		}

		if(obj == null){

			return false;

		}

		if(obj instanceof Rede){

			Rede r = (Rede) obj;
			return this.arvore.equals(((Rede)r).arvore) &&
					this.reservas.equals(((Rede)r).reservas);

		}else{

			return false;
		}

	}

	/**
	 * Devolve o raio de exploracao da rede
	 * @return - o raio de exploracao da rede
	 */
	public int raio() {

		return this.raio-1;

	}

	/**
	 * Diminui o raio de exploracao da rede para um dado valor
	 * @param n - o novo raio de exploracao 
	 * @requires n < this.raio
	 */
	public void diminuirRaioPara(int n) {


		if(arvore.height() < n){

			return;
		}

		LinkedBinaryTree<Character> arvore2 = diminuirRaio(arvore,n,0,true);
		arvore2 = diminuirRaio(arvore2,n,0,false);

		arvore=arvore2;


	}


	/***
	 * Metodo Auxiliar que "parte" a arvore
	 * 
	 * @param node arvore a partir/dimiuir raio
	 * @param heigth altura a querer partir
	 * @param currentH altura a que estah a arvore/no a partir
	 * @param isleft se ha ah esq
	 * @return
	 */
	private LinkedBinaryTree<Character> diminuirRaio(LinkedBinaryTree<Character> node, int heigth, int currentH, boolean isleft) {

		if(!node.isLeaf()){

			LinkedBinaryTree<Character> left = new LinkedBinaryTree<>();
			LinkedBinaryTree<Character> right = new LinkedBinaryTree<>();

			if(isleft){

				if(!node.leftSubtree().isEmpty()){

					left = diminuirRaio(node.leftSubtree(),heigth,currentH + 1,isleft);

				}
				if(currentH > heigth){

					reservas.offer(node.data());
				}
				if(!node.rightSubtree().isEmpty()){

					right = diminuirRaio(node.rightSubtree(),heigth,currentH + 1,isleft);

				}


			}else{

				if(!node.rightSubtree().isEmpty()){

					right = diminuirRaio(node.rightSubtree(),heigth,currentH + 1,isleft);

				}
				if(currentH > heigth){
					reservas.offer(node.data());

				}
				if(!node.leftSubtree().isEmpty()){

					left = diminuirRaio(node.leftSubtree(),heigth,currentH + 1,isleft);

				}
			}
			if(currentH > heigth){

				return new LinkedBinaryTree<>();

			}else{

				return new LinkedBinaryTree<>(node.data(),left,right);

			}
		}
		if(currentH > heigth){

			reservas.offer(node.data());
			return new LinkedBinaryTree<>();

		}
		else{

			return new LinkedBinaryTree<>(node.data(),new LinkedBinaryTree<>(),new LinkedBinaryTree<>());
		}


	}


	/**
	 * Completa a rede de exploracao de modo a ficar com todas as folhas possiveis, 
	 * na arvore binaria com a altura da rede de exploracao actual
	 * atraves da reativacao (quando possivel) de um explorador de reversa.
	 * O preenchimento eh feito partindo da esquerda e para a periferia. 
	 * Caso nao haja exploradores suficientes deve colocar num '*' nos espacos que 
	 * ficam por preencher.  
	 */
	public void preencherRede() {

		if(arvore.isLeaf()){
			return ;
		}

		LinkedBinaryTree<Character> arvore2 = preencherRede(arvore,arvore.height(),1,true);
		arvore2= preencherRede(arvore2,arvore.height(),1,false);

		arvore = arvore2;


	} 

	/**
	 * Metodo auxiliar para completar a rede de exploracao de modo a ficar com todas as folhas possiveis,
	 * na arvore binaria com a altura da rede de exploracao actual
	 * atraves da reativacao (quando possivel) de um explorador de reversa.
	 * O preenchimento eh feito partindo da esquerda e para a periferia. 
	 * Caso nao haja exploradores suficientes deve colocar num '*' nos espacos que 
	 * ficam por preencher.
	 * 
	 * @param no
	 * @param height 
	 * @param i
	 * @param isleaf
	 * @return
	 */
	private LinkedBinaryTree<Character> preencherRede(LinkedBinaryTree<Character> no, int height, int i,
			boolean isleaf) {

		if(!no.isLeaf()){

			LinkedBinaryTree<Character> left = new LinkedBinaryTree<>();
			LinkedBinaryTree<Character> right = new LinkedBinaryTree<>();

			if(isleaf){

				if(!no.leftSubtree().isEmpty()){

					left =  preencherRede(no.leftSubtree(),height,i,isleaf);

				}if(!no.rightSubtree().isEmpty()){

					right = preencherRede(no.rightSubtree(),height,i,isleaf);

				}

			}else{

				if(!no.rightSubtree().isEmpty()){

					right = preencherRede(no.rightSubtree(),height,i+1,isleaf);

				}
				if(!no.leftSubtree().isEmpty()){

					left = preencherRede(no.leftSubtree(),height,i+1,isleaf);
				}
			}
			if( height > i + no.height()){

				Character element = reservas.isEmpty() ? new Character('*') : reservas.element();

				return preencherRede(new LinkedBinaryTree<>(element,left,right),height,i+1,isleaf);
			}
			else{
				return new LinkedBinaryTree<>(no.data(),left,right);
			}


		}

		//falta o caso de height > i+1

		return null;
	}


	/**
	 * Existem exploradores inativos?
	 * @return true se ha exploradores desativos
	 */
	public boolean temExploradoresDeReserva() {

		return !this.reservas.isEmpty();
	} 

	/**
	 * preenche a rede, da esquerda para a direita, partindo do no c para a periferia da rede, 
	 * acrescentando todos os nos os existentes no grupo de exploradores de reserva. 
	 * @param c o nome do no de onde se parte 
	 * @return false sse c nao existem eh inapropriado (i.e, se ligacoes por atribuir) ou esta inactiov
	 * @requires
	 */
	public boolean distribuiRobosPartindoDe(char c) {

		if( arvore.occurrences(new Character(c)) == 0){

			return false;
		}
		if(reservas.isEmpty()){

			return true;
		}

		Iterator<Character> it = reservas.iterator();

		while(it.hasNext()){

			if(it.next().equals(c)){

				return false;

			}
		}

		LinkedBinaryTree<Character> arvoreEnd = distribuiRobos(arvore,c);

		if(arvoreEnd == null){

			return false;

		}

		arvore = arvoreEnd;

		return true;
	}


	/**
	 * Metodo auxiliar para distribuir os robos
	 * @param no no que repsenta a arvore
	 * @param c representar o nome onde se parte
	 * @return tree com os robos distribuidos
	 */
	private LinkedBinaryTree<Character> distribuiRobos(LinkedBinaryTree<Character> no,char c){

		if(no.data().equals(c)){

			if(!no.leftSubtree().isEmpty() && !no.rightSubtree().isEmpty()){

				return null;
			}
		}if(!no.isLeaf()){

			LinkedBinaryTree<Character> left = new LinkedBinaryTree<>();
			LinkedBinaryTree<Character> right = new LinkedBinaryTree<>();

			if(no.leftSubtree().isEmpty()){

				left = distribuiRobos(no.leftSubtree(),c);
			}
			if(no.rightSubtree().isEmpty()){

				right = distribuiRobos(no.rightSubtree(),c);
			}
			if(no.data().equals(c)){

				LinkedBinaryTree<Character> reserva = distribuiReservas(new LinkedBinaryTree<>());

				if(no.leftSubtree().isEmpty()){

					return new LinkedBinaryTree<>(no.data(),reserva,right);

				}else{

					return new LinkedBinaryTree<>(no.data(),left,right);
				}

			}else{

				return new LinkedBinaryTree<>(no.data(),left == null ? new LinkedBinaryTree<>():left,right==null ? new LinkedBinaryTree<>():right);
			}
		}
		if(no.data().equals(c)){

			LinkedBinaryTree<Character> reserva = distribuiReservas(no);
			return new LinkedBinaryTree<Character>(reserva.data(),reserva.leftSubtree(),reserva.rightSubtree());
		}
		return new LinkedBinaryTree<>(no.data());
	}


	/**
	 * Metodo auxiliar para distribuir as reservas/ para a distribuicao dos robos
	 * 
	 * @param node no que ira representar uma arvore 
	 */
	private LinkedBinaryTree<Character> distribuiReservas(LinkedBinaryTree<Character> node) {

		if(reservas.isEmpty()){

			return node;

		}if(node.leftSubtree().isEmpty()){

			Character elemento = reservas.element();
			reservas.remove();
			return distribuiReservas(new LinkedBinaryTree<Character>(node.data(),new LinkedBinaryTree<>(elemento),new LinkedBinaryTree<>() ));

		}else if(node.rightSubtree().isEmpty()){

			Character elemento = reservas.element();
			reservas.remove();
			return distribuiReservas(new LinkedBinaryTree<Character>(node.data(),node.leftSubtree(),new LinkedBinaryTree<>(elemento)));


		}else{

			return new LinkedBinaryTree<>(node.data(),distribuiReservas(node.leftSubtree()),distribuiReservas(node.rightSubtree()));
		}

	}


	/**
	 * devolve uma cadeia de caracteres que eh uma representação textual da rede de exploracao, 
	 * tal que um no aparece entre parentesis, seguido das sub-arvores esquerda e direita, 
	 * tambem entre parentesis
	 * @return (raiz(subarvoreEsquerda()subarvoreDireita()) 
	 * Por exemplo se a arvore for
	 * A
	 *  B
	 *   C
	 *   E
	 *  F
	 *   G
	 *    H
	 *   I
	 * 
	 * devolve a represetacao (A(B(C()E())F(G(H())I())))
	 */
	public String imprimeRedeParentesis() {


		return "(" + imprimeRedeParentesis(arvore,new StringBuilder()).toString() + ")";
	}




	/**
	 *Metodo auxiliar para a representacao textual da rede de exploracao,
	 * tal que um no aparece entre parentesis,seguido das sub-arvores
	 * 
	 * @param arvore2 arvore para representar
	 * @param sb stringbuilder que ira ter a representacao/onde vamos trabalhar a string
	 * @return StringBuilder com a rede de exploracao,com as arvores
	 * 			(raiz(subarvoreEsquerda()subarvoreDireita()) 
	 */
	private StringBuilder imprimeRedeParentesis(LinkedBinaryTree<Character> arvore2, StringBuilder sb) {

		if(arvore2 == null){

			return sb;
		}
		if(arvore2.isLeaf()){

			return sb.append("()");

		}
		if(!arvore2.leftSubtree().isEmpty()){

			sb.append('(');
			sb = imprimeRedeParentesis(arvore2.leftSubtree(),sb);
			sb.append(')');


		}
		if(!arvore2.rightSubtree().isEmpty()){

			sb.append('(');
			sb = imprimeRedeParentesis(arvore2.rightSubtree(),sb);
			sb.append(')');

		}
		return sb;
	}


	/**
	 * Devolve uma cadeia de caracteres com uma representacao
	 * textual da rede, com um no por linha, identica ah representacao no ficheiro de entrada e 
	 * ah fornecida pelo metodo toString da LinkedBinaryTree
	 * @return representacao textual da rede em forma de arvore   
	 */
	public String imprimeRede() {

		return arvore.toString();
	}

	/**
	 * Devolve uma cadeia de caracteres com uma representacao textual da rede dos exploradores 
	 * inactivos (em reserva), com todos os nos na mesma linha e separados por espacos.
	 * @return cadeia de caracteres com representacao textual da rede
	 * @requires tem que existir exploradores
	 */
	public String devolveGrupoReserva() {

		StringBuilder sb = new StringBuilder();

		for(Character elem : reservas){

			sb.append(elem + " ");

		}

		return sb.toString();
	}

}
