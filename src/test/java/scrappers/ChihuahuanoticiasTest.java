package scrappers;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Chihuahuanoticias;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by echavez on 6/14/16.
 */
public class ChihuahuanoticiasTest {

    Chihuahuanoticias chihuahua;

    @Before
    public void setup() {
        chihuahua = new Chihuahuanoticias("http://chihuahuanoticias.com/?p=126269");
    }


    @Test
    public void itShouldSetThumbnail() {

        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://chihuahuanoticias.com/wp-content/uploads/2016/06/dfasdfs1.jpg");
        assertEquals(thumbnails, chihuahua.getThumbnail());

    }

    @Test
    public void itShouldSetTitle() {
        assertEquals("Se reúne Miguel Riggs con Hector Barraza", chihuahua.getTitle());
    }

    @Test
    public void itShouldSetContent() {
        assertEquals("El dia de hoy Miguel Riggs síndico electo y su equipo de trabajo se reunió en el Palacio Municipal con Héctor Barraza. Estaremos acercándonos al Síndico para empezar a trabajar tendremos un área de controlaría central muy cercana a la sociedad; no habrá tintes partidistas dijo Miguel Riggs Por más de media hora, Riggs y Barraza acompañados del equipo de la Sindicatura dialogaron a puerta cerrada, pues el perredista le dejó claro al panista que en estos casi tres años se ha trabajado con responsabilidad.", chihuahua.getContent());
    }

}