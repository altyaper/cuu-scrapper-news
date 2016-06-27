package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.RedNoticias;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by echavez on 6/26/16.
 */
public class RedNoticiasTest extends StubService implements CommonTest {

    public String url = "http://larednoticias.com.mx/noticias.cfm?n=179423";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubRedNoticias.html", this.url);
        this.article = new RedNoticias(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Balean a sujeto en la colonia Campesina", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p class=\"lead\"> 26 de junio de 2016. </p> \n" +
                "<p class=\"lead\"> Chihuahua, Chih.- Un sujeto fue acribillado, cuando dos sujetos armados lo interceptaron y le dispararon en varias ocasiones en la colonia Campesina. </p> \n" +
                "<p>La víctima se encontraba en un negocio de discos 'piratas' sobre las calles Estheres y Miguelitos, cuando de repente llegaron dos sujetos a lugar. <br><br> Al estar ahí, los agresores bajaron de una camioneta pick up Ford de color oscuro, donde al ver a su víctima, sacaron sus armas y dispararon en contra del ciudadano en al menos cinco ocasiones, según informaron testigos. <br><br> La persona resultó con lesiones en la pierna y brazo derecho además del abdomen; por lo que tuvieron que llegar paramédicos de Cruz Roja para trasladar al herido a un nosocomio de la ciudad. <br><br> Policías municipales y estatales acordonaron los alrededores mientras que agentes de la Fiscalía recabaron toda la información posible para las investigaciones.</p>  \n" +
                " \n" +
                "<br>\n" +
                "<br>   \n", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://larednoticias.com.mx/fotos/baleado colonia campesina.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Destacadas", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheDate() {
        assertEquals("26 de junio de 2016", this.article.getDate());
    }
}
