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
    private final String url = "http://entrelineas.com.mx/local/sancionaran-a-conductores-de-uber-no-se-han-acercado-a-la-direccion-de-transporte/";

    @Before
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubPage/stubEntreLineas.html").toString().replace("file:", "");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8", this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);
        this.article = new EntreLineas(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Sancionarían a conductores de Über ante falta de concesión; no se han acercado a la Dirección de Transporte", article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<span class=\"noticias-de-cuu\">Noticias de Chihuahua.-</span>\n" +
                "<p>Tras el anuncio de la entrada de Über a Chihuahua y a Ciudad Juárez, el director de Transporte de Gobierno del Estado, Gustavo Morales González, aseguró que hasta el momento la empresa no se ha acercado directamente a la dependencia para plantear esta posibilidad, por lo que su actuar se encontraría fuera de la ley.</p> \n" +
                "<p>Morales González señaló que, de acuerdo a la legislación en la materia, la empresa requeriría de una concesión para poder operar en la entidad, sin embargo, en ningún momento ha enterado a Gobierno del Estado sobre su incursión al mercado de transporte.</p> \n" +
                "<p>En este tenor, el funcionario detalló que más allá de estar en contra de que la empresa ingrese en Chihuahua, se requiere que ésta se presente ante la Dirección de Transporte y, dado que no lo ha hecho, podrían ser sujeta a sanciones.</p> \n" +
                "<p>Cabe señalar que Über publicó en su página de internet el siguiente comunicado: “Estamos muy felices de anunciar la llegada de Über a Chihuahua y Ciudad Juárez este viernes 24 de junio, siguiendo con nuestro compromiso de ofrecer una opción de movilidad segura y eficiente”, lo que alertó de inmediato a los taxistas de la ciudad que ya han manifestado posibles movilizaciones.</p>", article.getContent());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Argelia Dominguez", article.getAuthor());
    }

    @Test
    public void itShouldGetTheThumbnail(){

        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://entrelineas.com.mx/wp-content/uploads/2016/06/Gustavo-Morales-570x399.jpg");

        assertEquals(thumbnails, article.getThumbnail());
    }
}
