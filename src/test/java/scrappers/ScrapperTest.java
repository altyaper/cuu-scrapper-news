package scrappers;

import org.junit.Before;
import org.junit.Test;
import utils.Scrapper;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by echavez on 5/23/16.
 */
public class ScrapperTest {

    Scrapper scrapper;

    @Before
    public void setup(){
        scrapper = new Scrapper("http://tiempo.com.mx/noticia/34564-robo_de_agua_en_la_ciudad_deja/1");
    }

    @Test
    public void itShouldScrapTheTitleOfTheArticle(){

        assertEquals("Robo de agua en la ciudad deja a decenas de familias sin servicio", scrapper.scrapTitle());

    }

    @Test
    public void itShouldScrapTheContentOfTheArticle(){

        assertEquals("JCAS informó que actualmente investigan 58 casos en la ciudad por tomas clandestinas de agua, mismos que ascienden por robo de hasta 47 mil litros usados en venta clandestina o llenar piscinas. La dependencia detalló que el último de los casos, de hace 12 días, fue por el robo de hasta 47 mil litros diarios de agua en Villa Juárez , misma que usaron para la re venta a través de purificadora. Además, otros de los casos fueron para entre otras cosas, llenar piscinas, regar jardines, abastecer granjas para fiestas, y hasta para las nogaleras, volúmenes de agua, que según la dependencia, fueron usadas sin control. Sobre ello, la Junta Central de Agua y Saneamiento declaró que esperan que los implicados paguen con hasta cinco años de prisión, además agregó que continuarán con la detección permanente de estas tomas clandestinas. Al respecto, la dependencia informó que la Fiscalía reúne los elementos para demostrar desde hace cuanto tiempo que sustraía el agua, la cantidad, los daños a la infraestructura y a los usuarios y así dictaminar las responsabilidades.", scrapper.scrapContent());

    }

    @Test
    public void itShouldScrapTheTagsOfTheArticle(){

        HashSet<String> tags = new HashSet<String>();
        tags.add("JCAS");

        assertEquals(tags, scrapper.scrapTags());

    }

    @Test
    public void itShouldScrapTheThumbnailOfTheArticle(){
        Set<String> hash = new HashSet<String>();
        hash.add("http://assets.tiempo.com.mx/uploads/imagen/imagen/44236/image.jpeg");
        assertEquals(hash, scrapper.scrapThumbnail());

    }

}
