/**
 * Classe que representa um sindicalista
 * @author Joao Miranda 
 * @date 20 Abr 2018
 *
 */
public class Sindicalista {

	private String nome;
	private Queue<Associado> naoPresencial;
	private Queue<Associado> presencial;
	private Area area;
	
	
    /**
     * Constroi um sindicalista dado o seu nome e a sua area
     * @param nome - o nome do sindicalista
     * @param area - a area do sindicalista
     * @requires nome, area != null
     */
    public Sindicalista(String nome, Area area) {
    	
    	this.nome = nome;
    	this.area = area;
    	this.naoPresencial = new Queue<Associado>();
    	this.presencial = new Queue<Associado>();
    	
    }

    /**
     * Devolve o nome deste sindicalista
     * @return o nome deste sindicalista
     */
    public String obtemNome () {
    	
    	return this.nome;
    	
    }

    /**
     * Devolve a area deste sindicalista
     * @return a area deste sindicalista
     */
    public Area obtemArea () {
    	
    	return this.area;
    	
    }

    /**
     * Devolve o numero de associados em espera para serem
     * atendidos por este sindicalista
     * @return o numero de associados em espera deste sindicalista
     */
    public int numeroAssociados () {
    	
        return this.presencial.size() + this.naoPresencial.size();
        
    }

    /**
     * Atruibui um dado associado a este sindicalista
     * @param associado - o associado a atribuir a este sindicalista
     * @requires associado != null
     */
    public void registaAssociado (Associado associado) {
    	
    	if(associado.obtemPrioridade()== Tipo.PRESENCIAL){
    		
    		this.presencial.enqueue(associado);
    		
    	}else{
    		
    		this.naoPresencial.enqueue(associado);
    	}
    }

    /**
     * Devolve a carga de servico deste sindicalista de acordo com o tipo 
     * de atendimento
     * Cada associado com tipo PRESENCIAL vale por 4 de tipo NAO PRESENCIAL
     * @param tipo o tipo de atendimento do qual se pretende saber a 
     * carga de atendimento
     * @return o numero ponderado de associados de acordo com o tipo  
     * @requires tipo != null
     */
    public int cargaDeServico (Tipo tipo) {
    	
        if(tipo == Tipo.PRESENCIAL){
        	
        	return this.presencial.size()*4;
        }
        
        return this.naoPresencial.size() + this.presencial.size()*4;
        
        
    }

    /**
     * Ainda tem associados em espera?
     * @return true sse ainda nao atendeu todos os associados que lhe foram atribuidos
     */
    public boolean aindaTemAssociados () {
    	
        return this.naoPresencial.isEmpty() && this.presencial.isEmpty();
        
    }

    /**
     * Qual o proximo associado a ser atendido por este sindicalista 
     * @return o proximo associado a ser atendido por este sindicalista
     * @requires aindaTemAssociados()
     */
    public Associado proximoAssociado () {
    	
    	Associado a;
    	
    	if(!this.presencial.isEmpty()){
    		
    		a = this.presencial.front().clone();
    		
    	}else{
    		
    		a = this.naoPresencial.front().clone();
    		
    	}
    	
    	return a;
    }

    /**
     * Finaliza o atendimento de um associado retirando-o da sua lista de espera
     * @return o associado que acabou de ser atendido por este sindicalista
     * @requires aindaTemAssociados()
     */
    public Associado atendeAssociado () {
    	
    	Associado a;
    	
    	if(!this.presencial.isEmpty()){
    		
    		a = this.presencial.front().clone();
    		this.presencial.dequeue();
    		
    	}
    	else{
    		
    		a = this.naoPresencial.front().clone();
    		this.naoPresencial.dequeue();
    		
    	}
    	
    	return a;
    }

    /**
     * Representacao textual deste sindicalista
     * 	"Nome
     *  	associados com tipo de atendimento presencial
     *  	associados com tipo de atendimento nao presencial
     * (caso haja associados). Se nao tiver associados deve
     *  informar que nao tem associados ah espera."
     *  
     *  @return representacao textual deste sindicalista
     */
    @Override
    public String toString () {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(obtemNome());
    	
    	if(!aindaTemAssociados()){
    		
    		sb.append("\nNao tem associados ah espera");
    		
    	}else{
    		sb.append("\n");
    		if(this.presencial.isEmpty()){
    			
    			sb.append(this.presencial.toString());
    			
    		}else {
    			sb.append(this.naoPresencial.toString());
    		}
    	}	
    	
    	return sb.toString();
    }
}
