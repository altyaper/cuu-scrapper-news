package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Chihuahuanoticias;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/14/16.
 */
public class ChihuahuanoticiasTest extends StubService implements CommonTest{

    public String url = "http://chihuahuanoticias.com/?p=126269";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubChihuahuanoticias.html", this.url);
        article = new Chihuahuanoticias(this.url, htmlProcessStub);
    }


    @Test
    public void itShouldSetThumbnail() {

        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://chihuahuanoticias.com/wp-content/uploads/2016/06/dfasdfs1.jpg");
        assertEquals(thumbnails, article.getThumbnail());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Se reúne Miguel Riggs con Hector Barraza", article.getTitle());

    }

    @Test
    @Override
    public void itShouldGetTheContent() {

        assertEquals("<p></p>\n" +
                "<p>El dia de hoy Miguel Riggs síndico electo y su equipo de trabajo se reunió en el Palacio Municipal con Héctor Barraza.</p>\n" +
                "<p>Estaremos acercándonos al Síndico para empezar a trabajar tendremos un área de controlaría central muy cercana a la sociedad; no habrá tintes partidistas dijo Miguel Riggs</p>\n" +
                "<p>Por más de media hora, Riggs y Barraza acompañados del equipo de la Sindicatura dialogaron a puerta cerrada, pues el perredista le dejó claro al panista que en estos casi tres años se ha trabajado con responsabilidad.</p>\n" +
                "<p class=\"no-break\">    </p>\n" +
                "<p> </p>", this.article.getContent());

    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Principal", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheTags() {

        Set<String> tags = new HashSet<>();
        tags.add("Chihuahua");
        tags.add("Miguel riggs");
        assertEquals(tags, this.article.getTags());

    }


}