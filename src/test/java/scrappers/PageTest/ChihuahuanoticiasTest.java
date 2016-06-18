package scrappers.PageTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Chihuahuanoticias;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

/**
 * Created by echavez on 6/14/16.
 */
public class ChihuahuanoticiasTest {

    public String url = "http://chihuahuanoticias.com/?p=126269";
    public Chihuahuanoticias chihuahua;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubChihuahuanoticias.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        chihuahua = new Chihuahuanoticias(this.url, htmlProcessStub);
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
        assertEquals("El dia de hoy Miguel Riggs síndico electo y su equipo de trabajo se reunió en el Palacio Municipal con Héctor Barraza. Estaremos acercándonos al Síndico para empezar a trabajar tendremos un área de controlaría central muy cercana a la sociedad; no habrá tintes partidistas dijo Miguel Riggs Por más de media hora, Riggs y Barraza acompañados del equipo de la Sindicatura dialogaron a puerta cerrada, pues el perredista le dejó claro al panista que en estos casi tres años se ha trabajado con responsabilidad.", chihuahua.getContent());
    }

}