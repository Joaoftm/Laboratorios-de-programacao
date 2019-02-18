import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx13Data {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoEData() {     
        esperado =  0;

        texto = "31-02-1934";
        obtido = padroes.data(texto);

        texto = "01-13-1982";
        obtido += padroes.data(texto);

        texto = "32-01-1342";
        obtido += padroes.data(texto);

        texto = "32-08-1234";
        obtido += padroes.data(texto);

        texto = "32-10-1234";
        obtido += padroes.data(texto);
        
        texto = "32-12-1234";
        obtido += padroes.data(texto);
        
        texto = "32-03-1234";
        obtido += padroes.data(texto);
        
        texto = "31-04-1234";
        obtido += padroes.data(texto);
        
        texto = "31-06-1234";
        obtido += padroes.data(texto);

        texto = "31-09-1234";
        obtido += padroes.data(texto);
        
        texto = "31-11-1234";
        obtido += padroes.data(texto);
        
        //Os anos bissextos nao contam!
        texto = "29-02-1234";
        obtido += padroes.data(texto);
        
        texto = "31-11-1234";
        obtido += padroes.data(texto);
        
        assertEquals(esperado, obtido);
    }

    @Test(timeout=1000)
    public void eData () {		
        esperado =  4;

        texto = "30-09-1234";
        obtido += padroes.data(texto);
        
        texto = "30-11-1234";
        obtido += padroes.data(texto);

        texto = "31-08-1234";
        obtido += padroes.data(texto);
        
        texto = "28-02-1234";
        obtido += padroes.data(texto);
        
        assertEquals(esperado, obtido);

    }

    


}
