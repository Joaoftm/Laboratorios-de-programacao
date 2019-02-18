import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx14Matriculas {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoEMatricula() {     
        esperado =  0;

        texto = "31-12-12";
        obtido = padroes.matricula(texto);

        texto = "FC-FC-12";
        obtido += padroes.matricula(texto);

        texto = "1-1-FC";
        obtido += padroes.matricula(texto);

        texto = "FC-12-1";
        obtido += padroes.matricula(texto);

        texto = "fc-12-12";
        obtido += padroes.matricula(texto);
        
        texto = "322-12-FC";
        obtido += padroes.matricula(texto);
        
        assertEquals(esperado, obtido);
    }

    @Test(timeout=1000)
    public void eMatricula () {		
        esperado =  3;

        texto = "99-01-FC";
        obtido += padroes.matricula(texto);
        
        texto = "FC-01-01";
        obtido += padroes.matricula(texto);

        //Admita como possivel 00
        texto = "00-FC-00";
        obtido += padroes.matricula(texto);
        
        
        assertEquals(esperado, obtido);

    }

    


}
