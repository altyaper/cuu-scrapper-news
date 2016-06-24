package scrappers.PageTest;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Opcion;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;


/**
 * Created by echavez on 5/23/16.
 */
public class OpcionTest implements CommonTest{

    public String url = "http://laopcion.com.mx/noticia/140178";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubOpcion.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        this.article = new Opcion(this.url, htmlProcessStub);

    }


    @Test
    public void itShouldSetTheAuthorOfTheArticle(){
        assertEquals("Daniela Jiménez", article.getAuthor());
    }

    @Test
    public void itShouldSetTheThumbnailOfTheArticle(){

        Set<String> hash = new HashSet<String>();
        hash.add("http://laopcion.com.mx/assets/2016/june/10/9vojCKDaMhGb.jpg");
        assertEquals(hash, article.getThumbnail());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Exigen pago decenas afuera de casa de campaña de Barraza", article.getTitle());
    }


    @Test
    public void itShouldGetTheCategory(){
        assertEquals("Local", article.getCategory());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p>Chihuahua.- Decenas de personas acudieron a las fueras de la casa de campaña del candidato independiente José Luis Barraza para exigir su pago tras trabajar como brigadistas en la búsqueda del empresario por la gubernatura. Los encargados se negaron a declarar ante los medios de comunicación.</p> \n" +
                "<p>Al término de la elección, alrededor de 100 personas acudieron a las inmediaciones de la que fungió como casa de campaña en Chihuahua de José Luis Barraza para solicitar que se les entregaran pagos pendientes por parte de los operadores del independiente.</p> \n" +
                "<p>Aunque la mayoría de las personas se negaron a dar información al respecto, una mujer, de forma anónima, dio a conocer que la gente acudió por pagos faltantes de los operadores del candidato independiente a los trabajadores, quienes están a la espera del dinero desde el martes.</p> \n" +
                "<p>Posteriormente, otra mujer que se negó a dar su nombre comentó que estos conflictos no provenían de José Luis Barraza, sino de su gente que además de negarles el pago se habían comportado de forma déspota contra muchos de ellos, incluso con algunas féminas.</p> \n" +
                "<p>Al intentar abordar a los encargados y guardias que se encontraban en el único acceso al inmueble, éstos se negaron a atender a los medios de comunicación y solicitaron que se retiraran, ya que ni las personas ni ellos tenían permitido dar declaraciones.</p>", article.getContent());
    }
}
