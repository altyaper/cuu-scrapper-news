package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Pueblo;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by echavez on 6/30/16.
 */
public class PuebloTest extends StubService implements CommonTest {

    public String url = "http://elpueblo.com/notas/Apoyara-Municipio-a-damnificados-por-llu";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubPueblo.html", this.url);
        this.article = new Pueblo(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Serie de Joan Sebastian le gana a \"El Señor de los Cielos\"", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("La serie \"Por siempre Joan Sebastian\", producida por Carla Estrada, superó en rating a la exitosa narcoserie \"El Señor de los Cielos\", ya que obtuvo 2.1 millones de espectadores en Estados Unidos. <br>\n" +
                "<p class=\"selectionShareable\">Lo anterior, de acuerdo a un reporte que se dió este día en el programa de radio&nbsp;&nbsp;\"La Taquilla\" , el cual se transmite desde la Ciudad de México.</p> \n" +
                "<p class=\"selectionShareable\">&nbsp;</p> \n" +
                "<p class=\"selectionShareable\">\"Por siempre Joan&nbsp;Sebastian\" se estrenó el pasado lunes a través de&nbsp;Univisión, mientras que el mismo día, la serie protagonizada por Rafael Amaya obtuvo 1.8 millones de televidentes en Telemundo, reveló la productora de la serie biográfica.</p> \n" +
                "<p class=\"selectionShareable\">&nbsp;</p> \n" +
                "<p class=\"selectionShareable\">A través de Twitter, Carla Estrada,&nbsp;productora de \"Por siempre Joan Sebastian\" ,&nbsp;agradeció el apoyo de los fans del \"poeta del pueblo\" .</p> \n" +
                "<div>\n" +
                " &nbsp;\n" +
                "</div> \n" +
                "<div>\n" +
                " &nbsp; \n" +
                " <p class=\"selectionShareable\">\"Por siempre Joan Sebastian\" tiene contemplado su estreno para México en los próximos meses, a través del canal 2 de Televisa.</p> \n" +
                "</div>", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://elpueblo.com/img/thumbnails_l/joanserie.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Farandula", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Redacción", this.article.getAuthor());
    }

    @Test
    public void itShouldGetTheDate() {
        Date expectedDate = new Date("Thu Jun 30 00:00:00 UTC 2016");
        assertEquals(expectedDate, this.article.getDate());
    }
}
