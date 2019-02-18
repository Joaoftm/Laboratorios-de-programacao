import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx15EuroOuDolar {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }


    @Test(timeout=1000)
    public void naoENemEuroNemDolar() {     
        esperado =  0;

        texto = "1.2.4€";
        obtido = padroes.euroOuDolar(texto);

        texto = "1.2.$";
        obtido += padroes.euroOuDolar(texto);

        texto = "$1.2.2";
        obtido += padroes.euroOuDolar(texto);

        texto = "1.€";
        obtido += padroes.euroOuDolar(texto);
        
        texto = ".5€";
        obtido += padroes.euroOuDolar(texto);

        assertEquals(esperado, obtido);
    }

    @Test(timeout=1000)
    public void eValorEmEuroOuDolar () {		
        esperado =  3;

        texto = "0.5€";
        obtido += padroes.euroOuDolar(texto);
        
        texto = "1€";
        obtido += padroes.euroOuDolar(texto);

        texto = "1.5$";
        obtido += padroes.euroOuDolar(texto);
        
        
        assertEquals(esperado, obtido);

    }

    


}
