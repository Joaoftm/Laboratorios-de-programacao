import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe Cluster
 * 
 * @author Joao Miranda ; n47143
 * @date 11 Maio 2018
 *
 */
public class Cluster {

	private String label;
	private String name;
	private ArrayList<Element> elements;
	private Element centroid;


	/**
	 * Cria um grupo (cluster) dado um elemento que serve de centroide
	 * e a sua designacao
	 * @param centroid - o elemento que serve de centroide
	 * @param s - a designcacao do cluster
	 * @requires centroid, s != null
	 */
	public Cluster (Element centroid, String s) {

		this.centroid = centroid.clone();
		this.name = s;
		this.label= this.centroid.getLabel();
		this.elements = new ArrayList<>();


	}

	/**
	 * Cria um grupo (cluster) dado um elemento que serve de centroide
	 * e a sua designacao
	 * @param centroid - o elemento que serve de centroide
	 * @param s - a designcacao do cluster
	 * @requires centroid, s != null
	 */
	public boolean add(Element e) {

		return this.elements.add(e);

	}

	/**
	 * O elemento ja pertence ao cluster
	 * @param e - o elemento a testar
	 * @return true sse e ja existe ni cluster
	 * @requires e != null
	 */
	public boolean contains(Element e) {

		return this.elements.contains(e);

	}

	/**
	 * Este cluster tem elementos? 
	 * @return true se nao ha elementos no cluster
	 */
	public boolean isEmpty() {

		return this.elements.isEmpty();

	}

	/**
	 * Informa o numero de elementos deste cluster
	 * @return o numero de elmentos no cluster
	 */
	public int size() {

		return this.elements.size();

	}



	/**
	 * Da uma forma de iterar sobre os elementos do cluster
	 * @return um iterador sobre os elementos deste cluster
	 */
	public Iterator<Element> iterator(){

		return this.elements.iterator();

	}


	/**
	 * Devolve a classificacao atribuida
	 * @return a classificacao dada
	 */
	public String getLabel () {

		return this.label;

	}


	/**
	 * Actualiza a classificacao deste cluster
	 * @param label a classificacao dada ao cluster
	 * @requires label != null
	 */
	public void setLabel (String label) {

		this.label = label;

	}


	/**
	 * Devolve copia dos elementos do cluster 
	 * @return uma copia dos elementos deste cluster
	 */
	public ArrayList<Element> getElements () {

		@SuppressWarnings("unchecked")
		ArrayList<Element> nova = ((ArrayList<Element>) elements.clone());

		return nova;
	}


	/**
	 * Uma copia do centroide deste cluster
	 * @return uma copia do centroide
	 */
	public Element getCentroid () {

		return this.centroid.clone();
	}

	/**
	 * Actualiza o centroide de acordo com a media dos elementos 
	 * deste cluster 
	 * @requires !isEmpty()
	 */
	public void updateCentroid() {

		double[] nb = new double[this.centroid.getFeaturesSize()];

		for(int i = 0; i < nb.length ; i++){

			double [] d = new double[elements.size()];

			for( int j = 0 ; j < d .length ; j++){

				d[j] = elements.get(j).getFeatures()[i];

			}

			nb[i] = media(d);
		}

		Element novo = new Element ("Centroid "+this.label,nb, this.label,1);
		this.centroid = novo;

	}

	/**
	 * Metodo auxiliar para o calculo da media dos elementos
	 * @param c array com os elementos a calcular a media
	 * @return double com o valor da media
	 * @requires tamanho de c não pode ser 0
	 */
	private double media(double[] c) {

		double media = 0.0;

		for(double d : c){

			media +=d;

		}

		return media/c.length;
	}

	/**
	 * Actualiza o centroide deste cluster para um dado elemento 
	 * @param e o novo centroide
	 * @requires e != null
	 */
	public void setCentroid (Element e) {

		this.centroid = e.clone();

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {

		StringBuilder sb = new StringBuilder("Cluster " + this.name+ ":\n");

		for(Element e : elements){

			sb.append("    "+e.toString()+"\n");

		}

		sb.append("centroid =" + centroid.toString()+ "\n");

		return sb.toString();
	}


	/**
	 * Calcula a variancia deste cluster
	 * @return Raiz quadrada da soma do quadrado das distancias de todos os elementos 
	 *          ao centroide deste cluster 
	 * @requires !isEmpty()
	 * @return a variancia deste cluster
	 */
	public double variance () {

		return Math.sqrt(quadrados());

	}

	/**
	 * Metodo auxiliar para calcular a raiz quadrada da soma do quadrado das distancias de todos os elementos
	 * @return double com o valor da raiz quadrada da soma do quadrado das distancias de todos os elementos
	 */
	private double quadrados() {

		double soma = 0.0;

		for(Element e : elements){

			soma+=Math.pow(e.distance(centroid), 2);

		}

		return soma;
	}

}
