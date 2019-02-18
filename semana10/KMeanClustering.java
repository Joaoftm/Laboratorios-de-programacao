import java.util.ArrayList;


/**
 * Classe KMeanClustering
 * 
 * @author Joao Miranda ; n47143
 * @date 11 Maio 2018
 *
 */
public class KMeanClustering {


	public static final int ITERATIONS = 100;

	public static final double DELTA = 0.0001;

	private ArrayList<Cluster> listaClusters;
	private Cluster[] grupos;

	/**
	 * Cria uma instancia de KMeanClustering agrupando
	 * os elementos de uma dada lista em cluster
	 * @param lista - o conjunto de elementos
	 * @param centroidesIniciais a lista com os centroides iniciais
	 * @requires lista != null e todos os seus elementos nao null
	 *          centroidesIniciais != null 
	 */
	public KMeanClustering(ArrayList<Element> lista, ArrayList<Element> centroidesIniciais) {

		this.listaClusters = new ArrayList<>();

		for(Element centroid : centroidesIniciais){

			Cluster c = new Cluster(centroid,Integer.toString(centroid.getType()));

			this.listaClusters.add(c);

		}

		adicionarCluster(lista);

	}

	/**
	 * Metodo auxiliar para adicionar os clusters na melhor lista
	 * 
	 * @param lista a colocar os clusters
	 * @requires lista.size >0
	 */
	private void adicionarCluster(ArrayList<Element> lista) {

		for(Element e : lista){

			double distance = Integer.MAX_VALUE;
			Cluster cluster = null;

			for(Cluster c : listaClusters){

				Element centroid = c.getCentroid();

				if( e.distance(centroid) < distance ){

					cluster = c;
					distance = e.distance(centroid);
				}

			}

			cluster.add(e);
			cluster.updateCentroid();
		}

	}


	/**
	 * Inicializa uma instancia de KMeanClustering agrupando
	 * os elementos de uma dada lista em cluster com centroides escolhidos aleatoriamente
	 * Nao se esqueca de alterar a label do cluster/centroide de acordo com a maioria dos seus elementos
	 * @param lista - o conjunto de elementos
	 * @param numClers o numero de centroides iniciais
	 * @requires lista != null e todos os seus elementos nao null
	 *          numCluster > 0 
	 */          
	public KMeanClustering(ArrayList<Element> lista, int numClusters) {

		this.listaClusters = new ArrayList<>();
		this.grupos = new Cluster[numClusters];

	}

	/**
	 * Devolve uma arrayList com os elementos da lista escalados para uma normal de media proximo de 0 e 
	 * desvio padrao proximo de 1.
	 * @param lista - a lista de elementos a renormalizar
	 * @return uma lista com elementos renormalizados para uma media aproximada de 0 e 
	 * desvio padrão de aproximada 1. (x --> (x - media)/desvio
	 */
	public static ArrayList<Element> rescale (ArrayList<Element> lista) {

		ArrayList<Element> res = new ArrayList<>();

		double[] listM = calculoMedia(lista);
		double [] lisD = calculoStdDev(lista,listM);

		for(int i = 0 ; i <lista.size();i++){

			res.add(new Element(lista.get(i).getName(), lisD, null, i));

		}

		return null;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {


		StringBuilder sb = new StringBuilder("Clusters Produced:    \n");

		for(Cluster c : listaClusters){

			sb.append("     "+c.toString()+ "\n");
		}

		return sb.toString();
	}


	/**
	 * Calcula a dissimilaridade dos grupos
	 * @return a soma das variancias dos cluster deste KMeanClustering
	 */
	public double dissimilarity() {

		double dissimilaridade = 0.0;

		for(int i = 0 ; i < grupos.length;i++){

			dissimilaridade += grupos[i].variance();


		}
		return dissimilaridade;
	}


	/**
	 * Determina com base na pre-classificacao o numero de elementos
	 * colocados nos clusters errados
	 * @return o numero de erros do cluster
	 */
	public int numWrongClassifications(){

		int soma = 0 ;

		for(int i = 0 ; i < grupos.length ; i++){

			int a = Integer.parseInt(grupos[i].getLabel());

			for(int j = 0 ; j < grupos[i].getElements().size();j++){

				if(a != grupos[i].getElements().get(j).getType()){

					soma++;

				}
			}

		}
		return soma;
	}



	/**
	 * Calcula o desvio padrao de um conjunto de dados
	 * @param lista - o conjunto de dados
	 * @param res - onde guarda os valores do desvio padrao de cada ma das componentes
	 * @return
	 */
	private static double[] calculoStdDev (ArrayList<Element> lista, double[] medias) {

		double[] featuresStdDev = new double [lista.get(0).getFeaturesSize()];

		for (Element e: lista) {
			double[] elemfeat = e.getFeatures();
			for (int i = 0; i < featuresStdDev.length; i++) {
				featuresStdDev[i] += Math.pow(elemfeat[i] - medias[i],2);
			}
		}

		for (int i = 0; i < featuresStdDev.length; i++) {
			featuresStdDev[i] = Math.sqrt(featuresStdDev[i] / lista.size());
		}

		return featuresStdDev;

	}

	/**
	 * Calcula a media de um conjunto de dados
	 * @param lista - o conjunto de dados
	 * @param res - onde guarda os valores da media de cada ma das componentes
	 * @return
	 */
	private static double[] calculoMedia (ArrayList<Element> lista) {
		double[] featuresMedia = new double [lista.get(0).getFeaturesSize()];

		//primeiro somar
		for (Element e: lista) {
			double[] elemfeat = e.getFeatures();
			for (int i = 0; i < featuresMedia.length; i++) {
				featuresMedia[i] += elemfeat[i];
			}
		}

		//depois dividir por quantos ha
		for (int i = 0; i < featuresMedia.length; i++) {
			featuresMedia[i] = featuresMedia[i]/(lista.size());
		}

		return featuresMedia;
	}


}
