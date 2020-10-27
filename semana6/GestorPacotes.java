import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Implementa metodos para a criacao de pacotes e operacoes sobre eles
 * @author Joao Miranda 
 * @date 13 Abr 2018
 */
public class GestorPacotes<E> {

    // limite de erro para comparacao de doubles
    public static final double DELTA_ERROR = 0.001;  
    public ArrayList<Pacote<E>> gest;
    public double capacidadePacotes;
    public int listaDeItems;

    /**
     * Cria um gestor de pacotes
     * @param listaDeItems
     * @param capacidadePacotes
     */
    public GestorPacotes (double capacidadePacotes) {
    	
    	this.capacidadePacotes = capacidadePacotes;
    	gest = new ArrayList<>();
    	
    	
     
    }


    /**
     * Cria pacotes a partir de uma lista de itens. Antes de criar
     * um novo pacote para cada item deve verificar se esse item
     * nao cabe num dos pacotes jah existente
     * @param listaDeItems a lista com os itens e os respetivos tamanhos
     * @requires listaDeItems.size()!= null;
     */
    public void criaPacotes (List<Par<E, Double>> listaDeItems) {
    	
    	Pacote<E> a = new Pacote<>(listaDeItems.size());
    	
    	//Pacote<Par<E,Double>> nova = new Pacote<>(listaDeItems.size());
    	
    	for(int i = 0; i < listaDeItems.size(); i ++){
    		
    		if(a.estaCheio()){
    			
    			gest.add(a);
    			
    			a = new Pacote<>(listaDeItems.size());
    			a.empacota(listaDeItems.get(i).primeiro(), listaDeItems.get(i).segundo());
    			
    		}else{
    			
    			a.empacota(listaDeItems.get(i).primeiro(), listaDeItems.get(i).segundo());
    			
    		}
    	}
    
        
    }




    /**
     * Diz quantos pacotes ha com uma capacidade ocupada maior que a dada
     * @param capacidade - o valor que o pacote deve ter atingido
     * @requires
     */
    public int quantosPacoteComACapacidade(double capacidade) {	
        
    	int contador = 0;
        
        for(int i = 0 ; i < gest.size() ; i++){
        	
        	if(gest.get(i).obtemCapacidadeOcupada()> capacidade){
        		
        		contador++;
        	}
        }
        return contador;
    }

    /**
     * Devolve uma lista de pacotes que contenham um dado item
     * @param item o elemento a pesquisar
     * @return Lista com cópia dos pacotes que contenham o elemento item
     */
    @SuppressWarnings("unchecked")
	public List<Pacote<E>> pesquisaPacotes( E item ) {
    	
    	
    	
    	Pacote <Par<E,Double>> a ;
    	ArrayList<Pacote<E>> nova = new ArrayList<>();
    	
    	for(int i = 0; i < gest.size(); i++){

        	// nao entendi o porque de nao me deixar usar gest.get(i),como fiquei com
    		// pouco tempo fiz esse cast e coloquei o SuppressWarnings
    		
    		a=(Pacote<Par<E, Double>>) gest.get(i);
    		Iterator<Par<E,Double>> it = a.iterator();
    		
    		while(it.hasNext()){
    			if(it.next().primeiro().equals(a)){
    				nova.add((Pacote<E>) a);
    				
    			}
    		}
    	}
    	
    	
        return nova;
    }

    /**
     * Representacao textual dos pacotes criados, um por linha
     */
    public String toString(){
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0 ; i < gest.size(); i ++){
    		
    		sb.append(gest.get(i) + "\n");
    	}
        return sb.toString();
    }

}
