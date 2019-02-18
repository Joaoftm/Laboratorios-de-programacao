import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx16Email {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoEEmail() {     
        esperado =  0;

//        texto = "f@fcul";
//        obtido = padroes.email(texto);
//
        texto = "f@f@f.com";
        obtido += padroes.email(texto);

        texto = "f@pt.come";
        obtido += padroes.email(texto);

        texto = "f.f@f.f";
        obtido += padroes.email(texto);

        assertEquals(esperado, obtido);
    }

    @Test(timeout=1000)
    public void eEmail () {		
        esperado =  4;

        texto = "f@fc.com";
        obtido += padroes.email(texto);
        
        texto = "fc@alunos.fc.com";
        obtido += padroes.email(texto);

        texto = "fc@fc.ul.pt";
        obtido += padroes.email(texto);
        
        texto = "fc@di.fc.ul.pt";
        obtido += padroes.email(texto);

        
        assertEquals(esperado, obtido);

    }

    


}
