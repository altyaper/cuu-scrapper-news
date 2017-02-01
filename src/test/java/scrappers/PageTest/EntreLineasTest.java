package scrappers.PageTest;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.EntreLineas;
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
 * Created by echavez on 6/20/16.
 */
public class EntreLineasTest implements CommonTest {

    private Article article;
    private Article article2;
    private final String url = "http://entrelineas.com.mx/entrelineas/audiencias-desangeladas-pan-con-lo-mismo-quemado-ex-auditor/";
    private final String url2 = "http://entrelineas.com.mx/mexico/pena-y-gobernadores-pactan-defender-a-paisanos/";

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        HtmlProcess htmlProcessStub2 = createMock(HtmlProcess.class);

        String dir = getClass().getResource("/stubPage/stubEntreLineas.html").toString().replace("file:", "");
        String dir2 = getClass().getResource("/stubPage/stubEntreLineasGaleria.html").toString().replace("file:", "");

        File file = new File(dir);
        File file2 = new File(dir2);

        Document document = Jsoup.parse(file, "UTF-8", this.url);
        Document document2 = Jsoup.parse(file2, "UTF-8", this.url);

        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        expect(htmlProcessStub2.getHtml(this.url2)).andStubReturn(document2);

        replay(htmlProcessStub);

        replay(htmlProcessStub2);

        this.article = new EntreLineas(this.url, htmlProcessStub);
        this.article2 = new EntreLineas(this.url2, htmlProcessStub2);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Peña y gobernadores pactan defender a paisanos en EU", article.getTitle());
    }

    @Test
    public void itShouldGetTheTitle2() {
        assertEquals("Ministeriales omiten alto y chocan contra familia", article2.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p>El presidente Enrique Peña Nieto y los gobernadores del país acordaron una serie de acciones para hacer valer la importancia de México como socio frente a Estados Unidos durante la próxima negociación para actualizar la relación bilateral y también, en defensa de los connacionales que viven en aquel país, informó la Agencia Notimex.</p> \n" +
                "<p>Al término del encuentro de más de 4 horas, el presidente de la Conago, Graco Ramírez explicó que los mandatarios que cuentan con casas de la amistad en los Estados Unidos, como el caso de Morelos, Estado de México, Oaxaca, Guanajuato, Zacatecas, Puebla y la Ciudad de México habrán de ponerlas a disposición de manera conjunta con la red de 50 consulados para la atención inmediata de quienes estén en riesgo de deportación por la política migratoria de Donald Trump.</p> \n" +
                "<p>“Tenemos información que hay cerca de 250 mil casos establecidos en tribunales norteamericanos y vamos a llegar a muchos más en una defensa con los consulados del Gobierno para hacer una defensa de todos los connacionales.</p> \n" +
                "<p>“Va a ser un precedente, se va a congestionar el sistema judicial norteamericano porque no vamos a permitir ningún alto unilateral violatorio de los derechos humanos y de lo que establecen los principios de convivencia de migrantes en todo el mundo”, subrayó.</p> \n" +
                "<p>Señaló que cada estado destinará recursos propios para pagar abogados y lo que se requiera para defender a los migrantes nacionales.</p> \n" +
                "<p>A ello se sumará un trabajo conjunto con alcaldes y gobernadores de estados como Nueva York, California, Chicago, Texas, Arizona y Nuevo México con quienes se encontrarán el 23 y 24 de febrero en Washington.</p> \n" +
                "<p>El también gobernador de Morelos, anunció que ante la solicitud que le hicieron los mandatarios estatales al Presidente de la República de que no aumente de nueva cuenta el precio de la gasolina este próximo 4 de febrero en solidaridad a la economía de las familias, Peña Nieto se comprometió a estudiar un esquema que suavice este impacto y a la vez no afecte las finanzas públicas.</p> \n" +
                "<p>El Presidente nos planteó qué en breve, en los próximos días va a anunciar, están haciendo un esfuerzo económico, una revisión económica para anunciar algo que no va a afectar sustantivamente el ingreso de los mexicanos” </p> \n" +
                "<p>A este encuentro al que acompañaron al Presidente Peña los secretarios de Relaciones Exteriores, Educación, Hacienda, Gobernación y de la SEP, solo faltó el gobernador de Aguascalientes, quien se disculpó por un problema personal. </p>", article.getContent());

        assertEquals("<p>Elementos de la policia ministerial circulaban por la Juan Escutia y periférico de la Juventud, cuando omitieron un alto y chocaron contra un vehículo Ford Escort.</p> \n" +
                "<p>En el vehículo viajaba una familia que resultó solamente con lesiones leves, las cuales fueron atendidas por paramédicos de la Cruz Roja.</p> \n" +
                "<p>Los elementos ministeriales aceptaron la responsabilidad de los hechos, por lo que agentes de vialidad tomaron notas del hecho.</p> \n" +
                "<p>&nbsp;</p>", article2.getContent());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Yuliana Nieto", article.getAuthor());
        assertEquals("Alejandra Rey", article2.getAuthor());
    }

    @Test
    public void itShouldGetTheThumbnail(){

        Set<String> thumbnailsGaleria = new HashSet<>();
        thumbnailsGaleria.add("http://um10k4d06a139gq9s27sjf51.wpengine.netdna-cdn.com/wp-content/uploads/2017/01/image-418-450x300.jpeg");
        thumbnailsGaleria.add("http://um10k4d06a139gq9s27sjf51.wpengine.netdna-cdn.com/wp-content/uploads/2017/01/image-419-450x300.jpeg");

        Set<String> thumbnail = new HashSet<>();
        thumbnail.add("http://um10k4d06a139gq9s27sjf51.wpengine.netdna-cdn.com/wp-content/uploads/2017/01/epngobers.jpg");

        assertEquals(thumbnail, article.getThumbnail());
        assertEquals(thumbnailsGaleria, article2.getThumbnail());
    }
}
