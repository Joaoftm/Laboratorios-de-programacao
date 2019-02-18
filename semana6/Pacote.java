import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Um pacote eh uma estrutura de dados que armazena um conjunto de items.
 * @author Joao Miranda ; n 47143
 * @date 13 Abr 2018
 * @param <E> O tipo dos items
 */
public class Pacote<E> implements Iterable<E>, Cloneable {
	
    public static final int NUM_MAX_ITEMS = 3;
    
    private ArrayList<E> pacote;
    private double capcidade;
    
    /**
     * Constroi este pacote
     * @param capacidade dimensao maxima que o pacote pode conter
     * @requires capacidade > 0
     */
    public Pacote(double capcidade) {
    	
    	pacote = new ArrayList<>(NUM_MAX_ITEMS);
    	this.capcidade = capcidade;
    	 
    }

    /**
     * Retorna a capacidade jah utilizada deste pacote
     */
    public double obtemCapacidadeOcupada() {
    	
        return this.capcidade;
        
    }


    /**
     * Retorna o numero de itens actualmente contidos neste pacote
     * @return numElems
     */
    public int obtemNumItems() {
    	
        return pacote.size();
        
    }

    /**
     * Informa se o pacote jah tiver o numero maximo de items permitido
     * @return verdadeiro se o pacote estiver ja tiver atingido o numo
     *          maximo de items
     */
    public boolean estaCheio() {
    	
        return pacote.size() == capcidade;
        
    }

    /**
     * Retorna verdadeiro se um item com uma dada dimensao cabe no pacote
     * @param double tamanho do item que se pretende verificar se cabe
     * @return verdadeiro se o pacote nao esta cheio e um item com aquela
     *      medida aidna cabe neste pacote
     * @requires tamanho > 0
     */
    public boolean cabe(double tamanho) {
    	
    	return NUM_MAX_ITEMS == obtemNumItems() &&  tamanho < (capcidade-obtemCapacidadeOcupada());
      
        
    }


    /**
     * Empacota um item se a caixa nao estiver cheia.
     * @param item -o item a ser empacotado
     * @param dimensaoDoItem - o tamanho que o item tem
     * @return false sse o item nao nao pode ser adicionado
     */
    public boolean empacota(E item, double dimensaoDoItem){
    	
    	if(cabe(dimensaoDoItem)){
    		
    		pacote.add(item);
    		
    		return true;
    		
    	}
    	else{
    		return false;
    	}
    }


    /**
     * Repesatcao textual dos itms do pacote
     */
    public String toString(){
    	
    	return pacote.toString();
        
    }

    
    
    /**
     * Metodo que ira possibilitar iterar sobre os "items" do pacote
     * @return items do pacote
     */
    public List<E> items(){
    	
    	ArrayList<E> items = new ArrayList<>();
    	
    	for(int a = 0 ; a < pacote.size();a++){
    		
    		if(pacote.get(a)!=null){
    			
    			items.add(pacote.get(a));
    		}
    	}
    	return items;
    }
    /**
     * Retorna um iterador capaz de atravessar todos os items 
     * presentes neste pacote
     * @return um iterador para percorrer os items do pacote
     */
    public Iterator<E> iterator() {
        
    	return pacote.iterator();
    }


    /**
     * Retorna uma copia deste Pacote
     * @return uma copia deste pacote
     * @throws CloneNotSupportedException 
     */
    @SuppressWarnings("unchecked")
	public Pacote<E> clone () {
    	
        return (Pacote<E>) pacote.clone();
    }
}
