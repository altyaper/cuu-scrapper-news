package scrappers.PageTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Tiempo;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 5/21/16.
 */
public class TiempoTest {

    public String url = "http://tiempo.com.mx/noticia/34340-desbandada_en_el_prd_renuncian/1";
    public Tiempo tiempo;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubTiempo.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        this.tiempo = new Tiempo(this.url, htmlProcessStub);
    }


    @Test
    public void itShouldSetTheTitleAsTheOriginalArticle(){
        assertEquals("Desbandada en el PRD; renuncian 500 integrantes y van con Maru Desbandada en el PRD; renuncian 500 integrantes y van con Maru".trim(), tiempo.getTitle());
    }

    @Test
    public void itShouldSetTheContentAsTheOriginalArticle(){

        String content =  "500 miembros del PRD e intregrantes de la Red Fuerza Chihuahua presentarán mañana su renuncia ante el partido del Sol Azteca y anunciaron su adhesión a la campaña de Maru Campos. Daniel Chávez, coordinador de dicho movimiento, mencionó que ante la crisis que vive el Partido de la Revolución Democrática y la falta de oportunidades dentro de dicho partido político, decidieron dejar dicho instituto político y unir ante la campaña de Maru Campos. Los coordinadores de sector del PRD destruyeron frente a los medios de comunicación las credenciales de afiliación y mostraron también las cartas de renuncia. \"El PRD no tiene liderazgo y sufre decaída fuerte, tan así que tuvieron que traer a candidato externo para poder levantar, por lo que ante la invitación hablamos con toda nuestra gente que son 500 personas y por unanimidad fuimos con Maru\": dijo. 500 miembros del PRD e intregrantes de la Red Fuerza Chihuahua presentarán mañana su renuncia ante el partido del Sol Azteca y anunciaron su adhesión a la campaña de Maru Campos. Daniel Chávez, coordinador de dicho movimiento, mencionó que ante la crisis que vive el Partido de la Revolución Democrática y la falta de oportunidades dentro de dicho partido político, decidieron dejar dicho instituto político y unir ante la campaña de Maru Campos. Los coordinadores de sector del PRD destruyeron frente a los medios de comunicación las credenciales de afiliación y mostraron también las cartas de renuncia. \"El PRD no tiene liderazgo y sufre decaída fuerte, tan así que tuvieron que traer a candidato externo para poder levantar, por lo que ante la invitación hablamos con toda nuestra gente que son 500 personas y por unanimidad fuimos con Maru\": dijo.";
        assertEquals(content, this.tiempo.getContent());

    }

    @Test
    public void itShouldGiveMeTheThumbnailAsTheOriginalArticle(){

        Set<String> hash = new HashSet<>();
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
