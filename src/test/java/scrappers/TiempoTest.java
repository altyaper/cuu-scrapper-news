package scrappers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 5/21/16.
 */
public class TiempoTest {

    public String url = "http://tiempo.com.mx/noticia/34340-desbandada_en_el_prd_renuncian/1";
    public Tiempo tiempo;

    @Before
    public void setup(){
         this.tiempo = new Tiempo(this.url);
    }

    @Test
    public void itShouldGetTheTitleFromaUrl(){
        assertTrue(this.tiempo.setHTML());
    }

    @Test
    public void itShouldSetTheTitleAsTheOriginalArticle(){
        assertEquals("Desbandada en el PRD; renuncian 500 integrantes y van con Maru".trim(), tiempo.getTitle());
    }

    @Test
    public void itShouldSetTheContentAsTheOriginalArticle(){

        String content =  "500 miembros del PRD e intregrantes de la Red Fuerza Chihuahua presentarán mañana su renuncia ante el partido del Sol Azteca y anunciaron su adhesión a la campaña de Maru Campos. Daniel Chávez, coordinador de dicho movimiento, mencionó que ante la crisis que vive el Partido de la Revolución Democrática y la falta de oportunidades dentro de dicho partido político, decidieron dejar dicho instituto político y unir ante la campaña de Maru Campos. Los coordinadores de sector del PRD destruyeron frente a los medios de comunicación las credenciales de afiliación y mostraron también las cartas de renuncia. \"El PRD no tiene liderazgo y sufre decaída fuerte, tan así que tuvieron que traer a candidato externo para poder levantar, por lo que ante la invitación hablamos con toda nuestra gente que son 500 personas y por unanimidad fuimos con Maru\": dijo.";
        assertEquals(content, this.tiempo.getContent());

    }

    @Test
    public void itShouldGiveMeTheThumbnailAsTheOriginalArticle(){

        List<String> hash = new ArrayList<String>();
        hash.add("http://assets.tiempo.com.mx/uploads/imagen/imagen/43903/image.jpeg");
        assertEquals(hash,this.tiempo.getThumbnail());

    }

    @Test
    public void itShouldGiveMeTheTagsAsTheOriginalArticle(){

        Set<String> hash = new HashSet<String>();

        hash.add("Sucesión 2016");
        hash.add("Política");
        hash.add("Chihuahua");

        assertEquals(hash, this.tiempo.getTags());

    }



}
