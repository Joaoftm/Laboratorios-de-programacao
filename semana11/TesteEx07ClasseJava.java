import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx07ClasseJava {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEClasse () {		
        esperado =  0;

        texto = "classe";
        obtido = padroes.classeJava(texto);

        texto = "cLasse";
        obtido += padroes.classeJava(texto);

        texto = "cLASSE";
        obtido += padroes.classeJava(texto);
        
        texto = "Classe_";
        obtido += padroes.classeJava(texto);
        
        texto = "_Classe";
        obtido += padroes.classeJava(texto);

        texto = "$Classe";
        obtido += padroes.classeJava(texto);

        texto = "Classe$";
        obtido += padroes.classeJava(texto);
        
        texto = "classe";
        obtido += padroes.classeJava(texto);

        texto = "";
        obtido += padroes.classeJava(texto);

        texto = " ";
        obtido += padroes.classeJava(texto);
        
        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eClasse () {       
        esperado =  5;

        texto = "Classe";
        obtido = padroes.classeJava(texto);

        texto = "ClAssE";
        obtido += padroes.classeJava(texto);

        texto = "CLASSE";
        obtido += padroes.classeJava(texto);

        texto = "Classe123";
        obtido += padroes.classeJava(texto);
       
        texto = "Cla123Sse";
        obtido += padroes.classeJava(texto);
        
        

        
        assertEquals(esperado, obtido);

    }

}
