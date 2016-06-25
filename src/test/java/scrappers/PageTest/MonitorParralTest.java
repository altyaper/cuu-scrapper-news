package scrappers.PageTest;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.MonitorParral;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * Created by echavez on 6/25/16.
 */
public class MonitorParralTest implements CommonTest {

    public String url = "http://www.elmonitorparral.com/notas.pl?n=82077";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubMonitorParral.html").toString().replace("file:", "");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8", this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        this.article = new MonitorParral(this.url, htmlProcessStub);

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Vehículos del accidente en carretera a juárez cuentan con permiso para circular: sct", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p class=\"nota-contenido\">La Secretaría de Comunicaciones y Transportes informa que en relación al accidente que se registró esta mañana a las 05:30 horas en el km 229+750 de la carretera 45 Ciudad- Juárez en el tramo de Sueco- Villa Ahumada los dos vehículos involucrados cuentan con permiso para circular del Servicio Público Federal. <br> <br>En el caso del autobús con placas 281 RN2, marca Dina modelo 1994 tiene registrado permiso de excursión a nombre de González Rivera Alberto Dionisio. El vehículo está domiciliado en el estado de Durango. <br> <br>Por otra parte, el tractocamión marca Keenwort placas 095DZ6, modelo 2001 cuya razón social es Transportes Algoza de Norte S.A. de C.V. se encuentra domiciliado en Ciudad Juárez y también cuenta con el permiso correspondiente. <br> <br>De acuerdo a los primeros reportes que se tienen de la Policía Federal, el accidente se registró mediante un choque alcance del autobús contra el tráiler por conducir a exceso de velocidad. <br> <br>El accidente dejó diez personas fallecidas y 29 lesionados, mismos que fueron trasladados a hospitales de Ciudad Juárez. <br> <br>La Secretaría de Comunicaciones y Transportes estableció la coordinación correspondiente con la Policía Federal a efecto de que la empresa concesionaria de autotransporte federal se haga cargo de los gastos a través del seguro de viajero y seguro de responsabilidad civil. <br> <br>Foto: http://eldiariodechihuahua.mx/ <br></p>", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://www.elmonitorparral.com/img/notas/82061_e93ce49b0f.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Reportero", this.article.getAuthor());
    }

    @Test
    public void itShouldGetTheDate() {
        assertEquals("24/06/2016 20:30", this.article.getDate());
    }
}
