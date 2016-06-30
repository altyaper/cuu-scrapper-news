package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.InformacionTotal;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by echavez on 6/30/16.
 */
public class InformacionTotalTest extends StubService implements CommonTest{

    public String url = "http://informaciontotal.com.mx/2016-06-29-be080277/nombramiento-del-fiscal-anticorrupcion-no-sera-durante-esta-administracion/";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubInformacionTotal.html", this.url);
        article = new InformacionTotal(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Nombramiento del Fiscal Anticorrupción no sera durante está administración", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("<p>Chihuahua, Chih.- Por medio de una entrevista el gobernador, César Duarte Jáquez, dio a conocer que el nombramiento del fiscal anticorrupción no está en sus manos ya que le correspondería a la próxima administración estatal.</p> \n" +
                "<p>Se le puso en duda en varios temas que han generado gran polémica a lo largo de su gestión, así como el “Banco Unión Progreso” donde se le acusó de desvío de recursos públicos para la creación del mismo, sin mencionar la iniciativa para la Fiscalía Anticorrupción.</p> \n" +
                "<p>“Ese nombramiento está establecido en la reforma que se dio, naturalmente, a propuesta del Ejecutivo y aprobada por el Congreso; pero no está agendado, en este momento el procedimiento”, indicó el funcionario.</p> \n" +
                "<p>Además se le cuestionó si es que dejaría una deuda a proveedores de su administración al gobernador entrante, a lo que respondió que se realizó una gestión en concesiones por parte del Presidente de la República, Enrique Peña Nieto, donde se otorgó un fideicomiso carretero, puntualizando que es un recurso único federal pero gracias a un acuerdo se le asignó al estado.</p> \n" +
                "<p>Sin embargo señaló que no es deuda si se hace uso de lo establecido en la Ley de Ingresos y Egresos, afirmando que sí hay recursos para pagarlos. Cabe mencionar que el pago de dichos compromisos con proveedores de esta administración contempla cumplirse con futuros ingresos de peaje, lo cual estaba presupuestado desde el año pasado.&nbsp;</p>", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://netnoticias.mx/im/2016/06/800x532-ESTAD130151_1.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    public void itShouldGetTheDate() {
        assertEquals("2016-06-29T21:30", this.article.getDate());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Redacción", this.article.getAuthor());
    }
}
