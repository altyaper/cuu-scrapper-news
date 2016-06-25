package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Cronica;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/13/16.
 */
public class CronicaTest extends StubService implements CommonTest{

    public String url = "http://www.cronicadechihuahua.com/Hoy-el-vigesimo-segundo-ejecutado,44533.html";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubCronica.html", this.url);
        article = new Cronica(this.url, htmlProcessStub);
    }


    @Test
    public void itShouldSetTheThumbnailOfTheArticle() {

        Set<String> hash = new HashSet<String>();
        hash.add("http://www.cronicadechihuahua.com/local/cache-gd2/74/dab0339cf11938f122e420b48af09f.jpg?1465850747");

        assertEquals(hash, article.getThumbnail());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Hoy, el vigésimo segundo ejecutado del mes en Juárez", article.getTitle());

    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p><em>**Es un individuo al que asesinaron a balazos, sujetos que venían a bordo de una camioneta y que lo dejaron tirado en la calle, en la colonia Águilas de Zaragoza.</em></p>\n" +
                "<p><i>Ciudad Juárez, Chih</i>.- En las calles de la Colonia Águilas de Zaragoza, fue asesinado un sujeto de entre 45 años de edad, quien fue sorprendido por sujetos a bordo de una camioneta quienes abrieron fuego en repetidas ocasiones y dejaron sin vida al sujeto sobre la calle.</p>\n" +
                "<p>El sujeto que perdió la vida en el lugar a consecuencia de los múltiples impactos de bala, fue identificado como David Levario de 45 años de edad, quien perdió la vida en cuestión de minutos al recibir varios impactos de bala la parte de la cabeza y en una pierna, según trascendió en el lugar de los hechos.</p>\n" +
                "<p>Paramédicos que acudieron al lugar decidieron llevar al sujeto a las instalaciones del la Clínica 66 del Instituto Mexicano del seguro Social, donde finalmente fue reportado como muerto en el lugar.</p>\n" +
                "<p>A pesar de que se colocaron retenes y operativos de búsqueda de los agresores, estos escaparon. Con este suceso suman a la fecha 22 crímenes en el mes.</p>", article.getContent());

    }
}