package scrappers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/14/16.
 */
public class NorteDigitalTest {
    NorteDigital norte;

    @Before
    public void setup(){
        norte = new NorteDigital("http://nortedigital.mx/hallan-cuerpo-acequia-campestre/");
    }

    @Test
    public void itShouldSetTheTitleOfTheArticle(){

        assertEquals("Hallan cuerpo en acequia de Senecú", norte.getTitle());

    }

    @Test
    public void itShouldSetTheThumbnailOfTheArticle(){

        List<String> hash = new ArrayList<String>();
        hash.add("http://nortedigital.mx/wp-content/uploads/2016/06/senecu.jpg");

        assertEquals(hash, norte.getThumbnail());

    }

    @Test
    public void itShouldSetTheContentOfTheArticle(){

        assertEquals("Esta tarde el cuerpo de un hombre fue localizado flotando en la acequia ubicada entre las calles Menorca y Camino Real de Senecú. El cadáver se encuentra en estado de descomposición, por lo tanto la identidad de la víctima no fue proporcionada por las autoridades que se presentaron al lugar del hallazgo. Fue necesario que el Heroico Cuerpo de Bomberos acudiera el lugar puesto que el cadáver estaba atorado debajo de un puente.  ", norte.getContent());

    }

    @Test
    public void itShouldSetTheAuthorNameOfTheArticle(){

        assertEquals("Héctor Dayer", norte.getAuthor());

    }
}
