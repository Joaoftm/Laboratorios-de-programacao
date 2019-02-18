import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx04NomeComApelido {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoENomeComApelido () {		
        esperado =  0;
        
        texto = "MariaCachucha";
        obtido = padroes.nomeComApelido(texto);

        texto = "maria Cachucha";
        obtido += padroes.nomeComApelido(texto);
        
        texto = "mariacachucha";
        obtido += padroes.nomeComApelido(texto);
        
        texto = "mARIAcACHUcha";
        obtido += padroes.nomeComApelido(texto);
        
        texto = "Maria cachuca";
        obtido += padroes.nomeComApelido(texto);
        
        texto = "Mar1a Cachucha";
        obtido += padroes.nomeComApelido(texto);
       
        texto = "Maria de Cachucha";
        obtido += padroes.nomeComApelido(texto);
        
        assertEquals(esperado, obtido);

    }
    
    @Test(timeout=1000)
    public void NomeComUmApelido () {        
        esperado =  1;
        
        texto = "Maria Cachucha";
        obtido = padroes.nomeComApelido(texto);
        
        assertEquals(esperado, obtido);

    }
    
    @Test(timeout=1000)
    public void NomeComMaisQueUmApelido () {        
        esperado =  0;
        
        texto = "Maria Cachucha Silva";
        obtido = padroes.nomeComApelido(texto);
        
        assertEquals(esperado, obtido);

    }
}
