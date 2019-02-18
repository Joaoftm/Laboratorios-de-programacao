import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx12CredenciaisFCUL {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoECredencial() {     
        esperado =  0;

        texto = "fc.12345";
        obtido = padroes.credencialAlunoFcul(texto);

        texto = "FC12";
        obtido += padroes.credencialAlunoFcul(texto);

        texto = "fcul12345";
        obtido += padroes.credencialAlunoFcul(texto);

        texto = "FC1245";
        obtido += padroes.credencialAlunoFcul(texto);

        
    }

    @Test(timeout=1000)
    public void eCredencialAlunoFcul () {		
        esperado =  3;

        texto = "fc00001";
        obtido += padroes.credencialAlunoFcul(texto);
        
        texto = "fc12345";
        obtido += padroes.credencialAlunoFcul(texto);

        texto = "fc99999";
        obtido += padroes.credencialAlunoFcul(texto);

        assertEquals(esperado, obtido);

    }

    


}
