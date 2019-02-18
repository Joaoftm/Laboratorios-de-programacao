import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx09OperadorAritmeticoJava {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEOperadorAritmeticoJava () {		
        esperado =  0;

        texto = "++";
        obtido = padroes.operadorAritmeticoJava(texto);

        texto = "&&";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "||";
        obtido += padroes.operadorAritmeticoJava(texto);
        
        texto = "6";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "o";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "x";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "o";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "|";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "&";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "?";
        obtido += padroes.operadorAritmeticoJava(texto);

        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eOperadorAritmeticoJava () {       
        esperado =  5;

        texto = "+";
        obtido = padroes.operadorAritmeticoJava(texto);

        texto = "%";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "/";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "*";
        obtido += padroes.operadorAritmeticoJava(texto);

        texto = "-";
        obtido += padroes.operadorAritmeticoJava(texto);
        
        assertEquals(esperado, obtido);

    }

}
