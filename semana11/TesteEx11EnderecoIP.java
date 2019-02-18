import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx11EnderecoIP {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoEEnderecoIPForma () {     
        esperado =  0;

        texto = "1.1.1.1.1";
        obtido = padroes.enderecoIP(texto);

        texto = "1.1.1";
        obtido += padroes.enderecoIP(texto);


    }

    @Test(timeout=1000)
    public void naoEEnderecoIP () {		
        esperado =  0;

        texto = "256.1.1.1";
        obtido += padroes.enderecoIP(texto);
        
        texto = "1.257.128.1";
        obtido += padroes.enderecoIP(texto);

        texto = "1.257.1.1";
        obtido += padroes.enderecoIP(texto);

        texto = "300.300.300.300";
        obtido += padroes.enderecoIP(texto);

        texto = "0.0.270.0";
        obtido += padroes.enderecoIP(texto);

        texto = "1.1.256.1";
        obtido += padroes.enderecoIP(texto);

        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eEnderecoIP () {       
        esperado =  8;

        texto = "1.1.1.1";
        obtido = padroes.enderecoIP(texto);

        texto = "0.0.0.0";
        obtido += padroes.enderecoIP(texto);

        texto = "00.01.1.1";
        obtido += padroes.enderecoIP(texto);

        texto = "10.10.10.10";
        obtido += padroes.enderecoIP(texto);
        
        texto = "010.010.10.001";
        obtido += padroes.enderecoIP(texto);

        texto = "128.128.128.128";
        obtido += padroes.enderecoIP(texto);
        
        texto = "255.10.101.2";
        obtido += padroes.enderecoIP(texto);
        
        texto = "110.110.100.255";
        obtido += padroes.enderecoIP(texto);

        assertEquals(esperado, obtido);

    }
    


}
