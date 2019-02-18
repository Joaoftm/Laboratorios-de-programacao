import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx10OperadorLogicoJava {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEOperadorLogicoJava () {		
        esperado =  0;

        texto = "++";
        obtido = padroes.operadorLogicoJava(texto);

        texto = "e";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "ou";
        obtido += padroes.operadorLogicoJava(texto);
        
        texto = "^";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "OU";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "x";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "??";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "|";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "&";
        obtido += padroes.operadorLogicoJava(texto);

        texto = "!!";
        obtido += padroes.operadorLogicoJava(texto);

        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eOperadorLogicoJava () {       
        esperado =  2;

        texto = "||";
        obtido = padroes.operadorLogicoJava(texto);

        texto = "&&";
        obtido += padroes.operadorLogicoJava(texto);

        assertEquals(esperado, obtido);

    }

}
