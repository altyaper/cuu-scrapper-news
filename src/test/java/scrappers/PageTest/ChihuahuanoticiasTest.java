package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Chihuahuanoticias;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/14/16.
 */
public class ChihuahuanoticiasTest extends StubService implements CommonTest{

    public String url = "view-source:http://chihuahuanoticias.com/?p=150588";
    public Article article;

    @Before
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubChihuahuanoticias.html", this.url);
        article = new Chihuahuanoticias(this.url, htmlProcessStub);
    }


    @Test
    public void itShouldSetThumbnail() {
        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://chihuahuanoticias.com/wp-content/uploads/2017/01/dfsa1.jpg");
        assertEquals(thumbnails, article.getThumbnail());

    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Interpone fiscal general juicio de nulidad ante resolución de la secretaría de la función pública", article.getTitle());
    }

    @Test
    public void itShouldGetTheDate() {
        Date expectedDate = new Date("Mon Jan 23 12:19:11 UTC 2017");
        assertEquals(expectedDate, article.getDate());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {

        assertEquals("<p>La Fiscalía General del Estado informa con relación a la nota periodista que circula en diversos medios electrónicos en la cual se da a conocer una suspensión provisional de tres meses en contra del Fiscal, César Peniche Espejel emitida por la Secretaría de la Función Pública Federal cuando fungió como Delegado Estatal de la PGR.</p>\n" +
                "<p>La supuesta falta que se le atribuye al Fiscal es haber dejado de dar trámite a unos documentos recibidos en la Delegación Estatal de la PGR, provenientes de una autoridad inexistente y por una diligencia que correspondía realizar a otra autoridad.</p>\n" +
                "<p>El pasado 12 de enero del año en curso, se interpuso en tiempo y forma la demanda de nulidad de la resolución dictada ante el Tribunal Federal de Justicia Administrativa, concediendo una suspensión provisional, a fin de que las cosas se mantengan en el estado en que se encuentran hasta en tanto se resuelva en definitiva el juicio de nulidad.</p>\n" +
                "<p>Se considera que la sanción impuesta es improcedente y excesiva, lo que deberá ser resuelto por el Tribunal Federal de Justicia Administrativa.</p>\n" +
                "<p>Durante 15 años en el servicio público en la PGR y al frente de diversas Unidades de alta responsabilidad, nunca antes ha sido sancionado y además cuenta con un expediente ejemplar.</p>\n" +
                "<p> </p>", this.article.getContent());

    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Chihuahua", this.article.getCategory());
    }


}