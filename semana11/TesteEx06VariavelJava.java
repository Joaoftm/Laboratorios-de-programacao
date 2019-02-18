import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx06VariavelJava {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEVariavel () {		
        esperado =  0;

        texto = "Variavel";
        obtido = padroes.variavelJava(texto);

        texto = "VARIAVEL";
        obtido += padroes.variavelJava(texto);

        texto = "VARIAVEL";
        obtido += padroes.variavelJava(texto);
        
        texto = "variavel_";
        obtido += padroes.variavelJava(texto);
        
        texto = "_variavel";
        obtido += padroes.variavelJava(texto);

        texto = "$variavel";
        obtido += padroes.variavelJava(texto);

        texto = "variavel$";
        obtido += padroes.variavelJava(texto);
        
        texto = "var.iavel";
        obtido += padroes.variavelJava(texto);

        texto = "123variavel";
        obtido += padroes.variavelJava(texto);

        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eVariavel () {       
        esperado =  5;

        texto = "variavel";
        obtido = padroes.variavelJava(texto);

        texto = "vARIAVEL";
        obtido += padroes.variavelJava(texto);

        texto = "vaRiavel";
        obtido += padroes.variavelJava(texto);

        texto = "variavel123";
        obtido += padroes.variavelJava(texto);
       
        texto = "varia123Vel";
        obtido += padroes.variavelJava(texto);

        
        assertEquals(esperado, obtido);

    }

}
