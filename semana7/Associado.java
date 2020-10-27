/**
 * Classe Associado
 * 
 * @author Joao Miranda 
 * @date 20 Abr 2018
 *
 */
public class Associado implements Cloneable{

	private Tipo tipo;
	private Area area;
	private String nome;
	private int ordemChegada;


	/**
	 * Construtor de um associado
	 * @param nome - o nome do associado
	 * @param ordemChegada - o numero de registo no sistema
	 * @requires  nome != null, ordemChegada > 0
	 */
	public Associado(String nome, int ordemChegada) {


		this.nome = nome;
		this.ordemChegada = ordemChegada;
		this.area = null;
		this.tipo = Tipo.NAO_PRESENCIAL;

	}

	/**
	 * diz o nome deste associado
	 * @return o nome do associado
	 */
	public String obtemNome () {

		return this.nome;
	}

	/**
	 * diz a ordem deste associado
	 * @return a ordem deste associado
	 */
	public int obtemOrdem () {

		return this.ordemChegada;
	}

	/**
	 * Atribui uma area de serviço a este associado
	 * @param area a area a atribuir
	 * @requires area != null
	 */
	public void atribuiServico (Area area) {

		this.area = area;
	}

	/**
	 * Obtem a area de serviço atribuida a este associado
	 * @return a area atribuida ao associado
	 */
	public Area obtemServico () {

		return this.area;
	}

	/**
	 * Atribui um tipo de atendimento (ou seja, uma prioridade)
	 * a este associado
	 * @param tipo o tipo de atendimento a atribuir
	 * @requires tipo != null
	 */
	public void atribuiPrioridade (Tipo tipo) {

		this.tipo = tipo;
	}

	/**
	 * Obtem o tipo de atendimento (ou seja, a prioridade)
	 * deste associado
	 * @return o tipo de atendimento deste associado
	 */
	public Tipo obtemPrioridade () {

		return this.tipo;
	}

	/**
	 * Representacao textual deste associado
	 *  * Exemplos:	(se ainda nao tem uma area nem tipo atribuidos)	
	 *                  	Associado Marco, ordem 3
	 *          	(se ja tem area e tipo atribuidos)       	
	 *                  	Associado Marco, ordem 3, GERAL, PRESENCIAL
	 * @return representacao textual deste associado
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Associado ").append(obtemNome()).append(", ").append("ordem").append(obtemOrdem());

		if(this.area!=null){

			sb.append(", ").append(this.area.name()).append(", ").append(this.tipo.name());

		}
		return sb.append("\n").toString();

	}


	/**
	 * Diz se um dado objecto eh igual a este associado
	 * @requires other != null
	 */
	@Override
	public boolean equals(Object other){
		
		boolean igual = false;

		if(this == other){

			return true;
			
		}else if(other instanceof Associado){
			
			Associado a = (Associado) other;
			return AssociadosIguais(a);
			
		}else {
			
			 igual = false;
			
		}

		return igual;
	}

	/**
	 * Metodo de apoio ah classe equals
	 * @param a outro associado/objecto a comparar
	 * 
	 * @return true ou false dependendo se eh igual ou nao
	 */
	private boolean AssociadosIguais(Associado a) {
		
		return obtemNome().equals(a.obtemNome()) && obtemOrdem()== a.obtemOrdem()
				&& this.obtemPrioridade()== a.obtemPrioridade()
				&& this.obtemServico() == a.obtemServico();
		
				
	}

	/**
	 * Devolve uma copia deste associado
	 */
	@Override
	public Associado clone() {
		
		try{
			
			Associado a = (Associado) super.clone();
			a.area= this.area;
			a.tipo = this.tipo;
			
			return a;
			
		}catch(CloneNotSupportedException e){
			
			throw new InternalError("");
			
		}
	}

}
