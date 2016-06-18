package scrappers.PageTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Cronica;
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
 * Created by echavez on 6/13/16.
 */
public class CronicaTest {

    public String url = "http://www.cronicadechihuahua.com/Hoy-el-vigesimo-segundo-ejecutado,44533.html";
    public Cronica cronica;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubCronica.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cronica = new Cronica(this.url, htmlProcessStub);
    }

    @Test
    public void itShouldSetTheTitleOfTheArticle(){

        assertEquals("Hoy, el vigésimo segundo ejecutado del mes en Juárez", cronica.getTitle());

    }

    @Test
    public void itShouldSetTheThumbnailOfTheArticle(){

        Set<String> hash = new HashSet<String>();
        hash.add("http://www.cronicadechihuahua.com/local/cache-gd2/74/dab0339cf11938f122e420b48af09f.jpg?1465850747");

        assertEquals(hash, cronica.getThumbnail());

    }

    @Test
    public void itShouldSetTheContentOfTheArticle(){

        assertEquals("**Es un individuo al que asesinaron a balazos, sujetos que venían a bordo de una camioneta y que lo dejaron tirado en la calle, en la colonia Águilas de Zaragoza. Ciudad Juárez, Chih.- En las calles de la Colonia Águilas de Zaragoza, fue asesinado un sujeto de entre 45 años de edad, quien fue sorprendido por sujetos a bordo de una camioneta quienes abrieron fuego en repetidas ocasiones y dejaron sin vida al sujeto sobre la calle. El sujeto que perdió la vida en el lugar a consecuencia de los múltiples impactos de bala, fue identificado como David Levario de 45 años de edad, quien perdió la vida en cuestión de minutos al recibir varios impactos de bala la parte de la cabeza y en una pierna, según trascendió en el lugar de los hechos. Paramédicos que acudieron al lugar decidieron llevar al sujeto a las instalaciones del la Clínica 66 del Instituto Mexicano del seguro Social, donde finalmente fue reportado como muerto en el lugar. A pesar de que se colocaron retenes y operativos de búsqueda de los agresores, estos escaparon. Con este suceso suman a la fecha 22 crímenes en el mes.".trim(), cronica.getContent());

    }
}
