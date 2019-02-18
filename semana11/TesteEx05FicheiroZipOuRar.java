import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEx05FicheiroZipOuRar {


    private int esperado;
    private int obtido;

    private String texto;

    private Padroes padroes;

    @Before
    public void setUp() {
        padroes = new Padroes();
    }



    @Test(timeout=1000)
    public void naoEZipNemRar () {		
        esperado =  0;
        
        texto = ".zip";
        obtido = padroes.ficheiroZipOuRar(texto);

        texto = ".rar";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "a.izip";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "a.Zip";
        obtido += padroes.ficheiroZipOuRar(texto);

        texto = "zip.a";
        obtido += padroes.ficheiroZipOuRar(texto);

        texto = "zip.Rar";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "ziprar.raro";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "ziprar.ziprar";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        assertEquals(esperado, obtido);

    }
    
    @Test(timeout=1000)
    public void eDoTipoZip () {      
        esperado =  4;
        
        texto = "a.zip";
        obtido = padroes.ficheiroZipOuRar(texto);

        texto = "zip.zip";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "Zip.zip";
        obtido += padroes.ficheiroZipOuRar(texto);

        texto = "ZIP.zip";
        obtido += padroes.ficheiroZipOuRar(texto);

        assertEquals(esperado, obtido);

    }   
    
    @Test(timeout=1000)
    public void eDoTipoRar () {      
        esperado =  4;
        
        texto = "a.rar";
        obtido = padroes.ficheiroZipOuRar(texto);

        texto = "zip.rar";
        obtido += padroes.ficheiroZipOuRar(texto);
        
        texto = "ZIP.rar";
        obtido += padroes.ficheiroZipOuRar(texto);

        texto = "Rar.rar";
        obtido += padroes.ficheiroZipOuRar(texto);

        assertEquals(esperado, obtido);

    }
}
