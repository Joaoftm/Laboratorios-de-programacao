/**
 * Classe imutavel para representar um par de elementos ordenado
 * @author Joao Miranda ; n47143
 * @date 13 Abr 2018
 */
public class Par<E, F> {
   
	
	private E e;
	private F f;
	
    /**
     * Cria um par imutavel com os dois items dados
     * @param e O primeiro elemento
     * @param f O segundo elemento do par
     */
    public Par(E e, F f) {
    	
    	this.e = e;
    	this.f = f;
    	
    }

    /**
     * @return O primeiro elemento do par
     */
    public E primeiro( ) {
    	
        return this.e;
        
    }

    /**
     * @return O segundo elemento do par
     */
    public F segundo() {
    	
        return this.f;
        
    }
    
}
