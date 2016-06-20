package scrappers;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.*;
import services.HtmlProcess;
import utils.Scrapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by echavez on 5/23/16.
 */
@org.junit.Ignore
public class ScrapperTest {

    public Scrapper scrapper;
    public String url = "";

    HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);

    @Before
    @org.junit.Ignore
    public void setup() throws IOException {

        String dir = getClass().getResource("/stubCover/stubChihuahuanoticiasCover.html").toString().replace("file:","");

        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        scrapper = new Scrapper("http://tiempo.com.mx/noticia/34564-robo_de_agua_en_la_ciudad_deja/1");
    }


    @Test
    public void itShouldGetAnArticleOfTiempo(){
        assertTrue(scrapper.getArticle() instanceof Tiempo);
    }

    @Test
    public void itShouldGetAnArticleOfOpcion() throws IOException {
        Scrapper scrapperopcion = new Scrapper("http://laopcion.com.mx/noticia/140178");
        assertTrue(scrapperopcion.getArticle() instanceof Opcion);
    }

    @Test
    public void itShouldGetAnArticleOfNorteDigital() throws IOException {
        Scrapper scrappernorte = new Scrapper("http://nortedigital.mx/hallan-cuerpo-acequia-campestre/");
        assertTrue(scrappernorte.getArticle() instanceof NorteDigital);
    }

    @Test
    public void itShouldGetAnArticleOfCronica() throws IOException {
        Scrapper scrappercronica = new Scrapper("http://www.cronicadechihuahua.com/Estrenan-tres-Bachilleratos,44555.html");
        assertTrue(scrappercronica.getArticle() instanceof Cronica);
    }

    @Test
    public void itShouldGetAnArticleOfEntreLineas() throws IOException {
        Scrapper scrappercronica = new Scrapper("http://entrelineas.com.mx/local/sancionaran-a-conductores-de-uber-no-se-han-acercado-a-la-direccion-de-transporte/");
        assertTrue(scrappercronica.getArticle() instanceof EntreLineas);
    }

    @Test
    public void itShouldGetAnArticleOfParadaDigital() throws IOException {
        Scrapper scrappercronica = new Scrapper("http://www.laparadadigital.com/noticias-de-chihuahua-mexico.cfm?n=72090");
        assertTrue(scrappercronica.getArticle() instanceof ParadaDigital);
    }


}
