package scrappers.PageTest;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.ParadaDigital;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by echavez on 5/21/16.
 */
public class ParadaDigitalTest implements CommonTest{

    public String url = "http://www.laparadadigital.com/noticias-de-chihuahua-mexico.cfm?n=72064";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubParadaDigital.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        this.article = new ParadaDigital(this.url, htmlProcessStub);
    }



    @Test
    public void itShouldGiveMeTheThumbnailAsTheOriginalArticle(){

        Set<String> hash = new HashSet<>();
        hash.add("http://www.laparadadigital.com/fotos/cruz-roja-vandalizada.jpg");
        assertEquals(hash,this.article.getThumbnail());

    }


    @Test
    public void itShouldGiveMeTheDate(){

        assertEquals("20 de junio de 2016", this.article.getDate());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Pedradas a la Cruz Roja por mal servicio".trim(), article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        String content =  "Chihuahua.- Una mujer agarró a pedradas las instalaciones de la Cruz Roja, al parecer por haber sostenido problemas con el servicio. El hecho ocurrió en la delegación norte, ubicada en Paseos de Chihuahua esta madrugada, y la responsable esta detenida. Según se indicó, la mujer lapidó las puertas de cristal, y por fortuna unidades de policía municipal pasaban por el lugar y observaron el hecho deteniéndola. Se indicó que las instalaciones se encontraban cerradas, y no hubo personas lesionadas solo daños materiales. Se indicó que la mujer tenía problemas emocionales, y que tuvo problemas con el servicio.";
        assertEquals(content, this.article.getContent());
    }
}
