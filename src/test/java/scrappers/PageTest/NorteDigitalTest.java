package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.NorteDigital;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/14/16.
 */
public class NorteDigitalTest extends StubService implements CommonTest {

    public String url = "http://nortedigital.mx/hallan-cuerpo-acequia-campestre/";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubNorteDigital.html", this.url);
        article = new NorteDigital(this.url, htmlProcessStub);
    }


    @Test
    public void itShouldSetTheThumbnailOfTheArticle() {

        Set<String> hash = new HashSet<String>();
        hash.add("http://nortedigital.mx/wp-content/uploads/2016/06/senecu.jpg");

        assertEquals(hash, article.getThumbnail());

    }


    @Test
    public void itShouldSetTheAuthorNameOfTheArticle() {

        assertEquals("Héctor Dayer", article.getAuthor());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Hallan cuerpo en acequia de Senecú", article.getTitle());

    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        String content = "<p>Esta tarde el cuerpo de un hombre fue localizado flotando en la acequia ubicada entre las calles Menorca y Camino Real de Senecú.</p> \n" +
                "<p>El cadáver se encuentra en estado de descomposición, por lo tanto la identidad de la víctima no fue proporcionada por las autoridades que se presentaron al lugar del hallazgo.</p> \n" +
                "<p>Fue necesario que el Heroico Cuerpo de Bomberos acudiera el lugar puesto que el cadáver estaba atorado debajo de un puente.</p> \n" +
                "<p>&nbsp;</p>";
        assertEquals(content, article.getContent());

    }

    @Test
    public void itShouldGetTheTags() {

        Set<String> tags = new HashSet<>();
        tags.add("Acequia");
        tags.add("Cadaver");
        tags.add("Senecu");

        assertEquals(tags, this.article.getTags());

    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Juárez", this.article.getCategory());
    }
}
