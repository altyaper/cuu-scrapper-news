package scrappers.PageTest;

import scrappers.scrapperPage.Diario;
import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
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
 * Created by echavez on 6/23/16.
 */
public class DiarioTest implements CommonTest {


    private Article article;
    private Article article2;
    private final String url = "http://eldiariodechihuahua.mx/Local/2016/06/22/detienen-a-100-personas-provienen-algunas-de-oaxaca-y-del-sur-del-pais/";

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        HtmlProcess htmlProcessStub2 = createMock(HtmlProcess.class);

        String dir = getClass().getResource("/stubPage/stubDiario.html").toString().replace("file:", "");
        String dir2 = getClass().getResource("/stubPage/stubDiarioVideo.html").toString().replace("file:", "");

        File file = new File(dir);
        File file2 = new File(dir2);

        Document document = Jsoup.parse(file, "UTF-8", this.url);
        Document document2 = Jsoup.parse(file2, "UTF-8", this.url);

        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        expect(htmlProcessStub2.getHtml(this.url)).andStubReturn(document2);

        replay(htmlProcessStub);

        replay(htmlProcessStub2);

        this.article = new Diario(this.url, htmlProcessStub);
        this.article2 = new Diario(this.url, htmlProcessStub2);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Detienen a 100 personas; provienen algunas de Oaxaca y del sur del país", article.getTitle());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://eldiariodechihuahua.mx/imagesnotas/2016/06/LOC123312635fedf4b_0.jpg");
        assertEquals(thumbnails, article.getThumbnail());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        String content = "<em><strong>Chihuahua, Chih.-</strong></em> La Fiscalía General informa en torno a los hechos que se registraron durante este miércoles al exterior de Palacio de Gobierno en donde un grupo de personas se manifestaron de manera violenta; agentes de la Policía Estatal Única actuaron conforme a los protocolos de seguridad con la activación de un operativo de contención ante la serie agresiones que se suscitaron.\n" +
                "<br>\n" +
                "<br> La actuación de los elementos de la Policía Estatal fue con la finalidad de resguardar el edificio sede del Poder Ejecutivo del Estado y la seguridad de las personas que ahí se encontraban laborando, misma protección que se brindó a los comercios aledaños y particulares, de la misma manera se desalojó a un grupo de alumnos de nivel básico que visitaban el Museo Casa Chihuahua para proteger su integridad.\n" +
                "<br>\n" +
                "<br> Los elementos de la Policía en sus distintas divisiones participaron de acuerdo al marco de la Ley, aplicando las técnicas correspondientes y atendiendo los disturbios civiles.\n" +
                "<br>\n" +
                "<br> De acuerdo a los reportes policiacos, desde temprana hora, doscientos cincuenta personas se aglutinaron en el cruce de las avenidas Aldama y Libertad, posteriormente iniciaron los actos de vandalismo en el recinto histórico, generando daños en ventanas, cristales, paredes y puertas.\n" +
                "<br>\n" +
                "<br> \n" +
                "<strong>Lo anterior dejó como saldo:</strong>\n" +
                "<br>\n" +
                "<br> * 100 personas detenidas, algunas de ellas provenientes de Oaxaca y otros estados del sur del país, por los delitos de daños, lesiones, sedición y motín. A uno de los manifestantes detenidos se le aseguró una arma de fuego calibre .380 marca Glock, por lo cual, está representación social lleva a cabo las investigaciones en torno a la procedencia de la misma.\n" +
                "<br>\n" +
                "<br> * 18 Agentes de la Policía Estatal Única lesionados; uno de ellos con una fractura de gravedad en la región cefálica.\n" +
                "<br>\n" +
                "<br> * Tres unidades vandalizadas de las cuales fueron sustraídas del interior de las patrullas dañadas, cuatro armas de fuego de alto poder, dos armas largas calibre .223 automáticas y dos pistolas calibre .9mm\n" +
                "<br>\n" +
                "<br> * De la misma manera son evaluados los daños ocasionados al edificio de Palacio de Gobierno, el cual es patrimonio histórico cultural, en tanto que el Instituto Nacional de Antropología e Historia (INAH) rendirá un informe sobre los mismos, y presentará la respectiva querella.\n" +
                "<br>\n" +
                "<br> La Fiscalía General del Estado, continuará con las investigaciones pertinentes para determinar la responsabilidad de quienes participaron en estos hechos a través de la revisión de diversas evidencias que se tienen como: testimoniales, materiales fotográficos y videos.\n" +
                "<br>\n" +
                "<br> La Policía Estatal Única mantiene una alerta máxima ante la posibilidad de que se presenten nuevas agresiones a inmuebles o a civiles.\n" +
                "<br>\n" +
                "<br>";

        assertEquals(content, this.article.getContent());

    }

    @Test
    public void itShouldGetTheCategory(){
        assertEquals("Local", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheThumbnail2(){
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://eldiariodechihuahua.mx/imagesnotas/2016/06/ESP1233634fb684b0e_0.jpg");
        assertEquals(thumbnails, this.article2.getThumbnail());
    }

}
