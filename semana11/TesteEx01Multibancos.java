import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx01Multibancos {
	

	private int esperado;
	private int obtido;
	
	private String texto;
	
	private Padroes padroes;
	
    @Before
    public void setUp() {
        padroes = new Padroes();
    }

	
	
	@Test(timeout=1000)
	public void comMenosDeQuatroAlgarismos () {		
		
	    texto = "123";
	    
		esperado = 	0;
		obtido = padroes.multibanco(texto);
		
		assertTrue(esperado == obtido);

	}
	
    @Test(timeout=1000)
    public void comQuatroAlgarismos () {     
        
        texto = "1234";
        
        esperado =  1;
        obtido = padroes.multibanco(texto);
        
        assertTrue(esperado == obtido);

    }
	
    @Test(timeout=1000)
    public void comMaisDeQuatroAlgarismos () {     
        
        texto = "12345";
        
        esperado =  0;
        obtido = padroes.multibanco(texto);
        
        assertTrue(esperado == obtido);

    }
	
}
