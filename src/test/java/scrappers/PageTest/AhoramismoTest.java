package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Ahoramismo;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by echavez on 6/25/16.
 */
public class AhoramismoTest extends StubService implements CommonTest {

    public String url = "http://ahoramismo.mx/hallan-a-pareja-ejecutada-al-sur-de-la-ciudad/";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubAhoramismo.html", this.url);
        article = new Ahoramismo(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Hallan a pareja ejecutada al sur de la ciudad", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p style=\"text-align: justify;\"><strong>LaRedacción</strong></p> \n" +
                "<p style=\"text-align: justify;\">Los cadáveres de un hombre y una mujer fueron localizados tirados en un paraje solitario al sur de la ciudad de Chihuahua en las colindancias con el municipio de Aquiles Serdán.</p> \n" +
                "<p style=\"text-align: justify;\">Personas que caminaban por detrás de la planta productora Vitromex fueron quienes reportaron a los números de emergencia el hallazgo de ambos cadáveres por lo que policías de ambos municipios atendieron el llamado.</p> \n" +
                "<p style=\"text-align: justify;\">La escena del crimen fue asegurada y se confirmó la presencia de un cadáver masculino y otro femenino ambos con huellas de violencia externa al parecer con impactos de bala en diferentes partes del cuerpo.</p> \n" +
                "<p style=\"text-align: justify;\">El hallazgo fue realizado alrededor de las 05:00 horas de este sábado y personal del Servicio Médico Forense se encargó de levantar los cadáveres y trasladarlos a las instalaciones del Complejo de Seguridad Pública Estatal para la práctica de la necropsia de ley y el protocolo de identificación.</p> \n" +
                "<p style=\"text-align: justify;\">Foto: archivo</p> \n" +
                "<div class=\"tagcloud\"></div>", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://ahoramismo.mx/wp-content/uploads/2014/12/semefo8oct-702x336.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }
    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Inseguridad", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Redacción", this.article.getAuthor());
    }

    @Test
    public void itShouldGetTheDate() {
        assertEquals("2016-06-25T10:19:21+00:00", this.article.getDate());
    }
}
