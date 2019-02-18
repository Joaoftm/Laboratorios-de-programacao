import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx08ComentarioSimplesJava {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEComentario () {		
        esperado =  0;

        texto = "nao eh comentario";
        obtido = padroes.comentarioSimplesJava(texto);

        texto = "* tambem nao";
        obtido += padroes.comentarioSimplesJava(texto);

        texto = "/ este tb nao";
        obtido += padroes.comentarioSimplesJava(texto);
        
        assertEquals(esperado, obtido);

    }


    @Test(timeout=1000)
    public void eComentario () {       
        esperado =  4;

        texto = "//";
        obtido = padroes.comentarioSimplesJava(texto);

        texto = "// comentario";
        obtido += padroes.comentarioSimplesJava(texto);

        texto = "/// comentario";
        obtido += padroes.comentarioSimplesJava(texto);

        texto = "//* comentario ";
        obtido += padroes.comentarioSimplesJava(texto);
       
        assertEquals(esperado, obtido);

    }

}
