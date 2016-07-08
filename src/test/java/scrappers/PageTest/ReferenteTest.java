package scrappers.PageTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import models.Article;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Referente;
import services.HtmlProcess;

/**
 * Created by echavez on 7/6/16.
 */
public class ReferenteTest extends StubService implements CommonTest  {

    public String url = "http://referente.mx/@Ivette/diputados-aprueban-nueva-deuda-de-6-mil-millones-de-pesos";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubReferente.html", this.url);
        this.article = new Referente(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Diputados aprueban nueva deuda de 6 mil millones de pesos", this.article.getTitle());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://referente.mx/public/assets/2016/jul/06/obj5514/big_33ppmtkd.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        String content = "<p>Con 23 votos a favor, 8 en contra y 0 abstenciones, el Congreso del Estado aprobó la nueva deuda para el Estado de Chihuahua, con esto se da acceso al ejecutivo a 6 mil millones de pesos provenientes del peaje carretero de los próximos años.</p>\n" +
                "<p>Quienes votaron en contra, son los 6 diputados de la bancada de el PAN, la diputada del PRI Teporaca Romero y America Aguilar del PT. </p>\n" +
                "<p><br></p>\n" +
                "<img src=\"http://referente.mx/public/assets/2016/jul/06/obj5514/ia1s2gkivu.png\" alt=\"ia1s2gkivu.png\">\n" +
                "<p>El dictamen menciona que con la monetización que hoy se aprobó Gobierno del Estado accedería a 6 mil millones de pesos, de los cuales, 3 mil van destinados a pagar un financiamiento que se solicitó en el 2015, y los otros 3 mil van destinados a pagar inversión pública.<br></p>\n" +
                "<p>La sesión duró dos horas y media, tiempo en el que los diputados expresaron su posicionamiento respecto a la iniciativa en cuestión. </p>\n" +
                "<p>El diputado Eleuterio Muñoz indicó que el Estado tiene proyectado recibir 52 millones de pesos de aquí al 2048 derivado de las concesiones carreteras, con la aprobación de la nueva deuda, se habrían ya bursatilizado 21 mil, quedando para Javier Corral y las siguientes administraciones solo 31 millones de pesos aproximadamente.</p>\n" +
                "<p>Con esto, César Duarte, tan solo en su gobierno gastaría por adelantado más de la tercera parte de los recursos carreteros que podría obtener el Estado en 32 años, es decir, el dinero que podrían aprovechar 2 administraciones más.</p>\n" +
                "<p>La primera en pedir el uso de la voz fue la diputada Paloma Aguirre, solicitando a los diputados que voten en contra de el decreto en discusión tomando en cuenta que en la administración de Cesar Duarte se ha incrementado en un 315% más la deuda del Estado en los 6 años de su administración con un total de 44 millones 399 mil 709 pesos. </p>\n" +
                "<p>“No cabe duda, que la actual administración oficiosamente se ha ganado un “record guinness\", por haber escrito la página más negra de la historia en Chihuahua… En otras palabras, “<i>el mayor desfalco financiero de la historia\". </i>Tan es así, que desde el inicio de la actual administración el Gobernador del Estado, Cesar Duarte Jaquez, en contubernio con el grupo dominante del Poder Legislativo, se han convertido en una poderosa maquinaria para procesar decenas de decretos que le ha permitido contraer deuda al Gobierno, sin ningún beneficio social para nuestra comunidad\", declaró.</p>\n" +
                "<div class=\"facebookbox facebookbox1\"> \n" +
                " <div class=\"fb-page\" data-href=\"https://www.facebook.com/elreferentemx/\" data-width=\"500\" data-small-header=\"true\" data-adapt-container-width=\"true\" data-hide-cover=\"false\" data-show-facepile=\"true\">\n" +
                "  <blockquote cite=\"https://www.facebook.com/elreferentemx/\" class=\"fb-xfbml-parse-ignore\">\n" +
                "   <a href=\"https://www.facebook.com/elreferentemx/\">Referente.mx</a>\n" +
                "  </blockquote>\n" +
                " </div> \n" +
                "</div>\n" +
                "<p></p>\n" +
                "<p>Posteriormente, el diputado Eleuterio Muñoz retomó el micrófono para declarar que esta iniciativa había sido propuesta y aprobada ya por todos los diputados a excepción de Humberto Perez en la Ley de Ingresos del Estado de Chihuahua. </p>\n" +
                "<p>Además señaló que es la única opción viable para el funcionamiento del Estado, de lo contrario, tendría que aumentarse los impuestos a los ciudadanos, realizarse recortes muy grandes de personal y aún así no se lograría. </p>\n" +
                "<p>“Nosotros pretendemos autorizar el instrumento a través del cual el Gobierno del Estado acceder a estos recursos, esto no es una ocurrencia ni es algo que se presentó repentinamente o a hurtadillas. Esto se aprobó en la ley de ingresos y todos los diputados lo aprobaron a excepción del diputado Humberto Perez. Esta iniciativa ya se había previsto subir y presentar en este pleno y decidimos de forma responsable bajarla, no presentarla y reunirnos con los equipos de transición del gobierno entrante y la actual administración\", indicó señalando que esta reunión no se concretó.</p>\n" +
                "<p>Por su parte, el diputado del PAN Humberto Perez solicitó una moción para que el dictamen pudiera regresarse a las comisiones a fin de que se discuta con el equipo de transición de gobierno, cuestionando a los legisladores de la Comisión de Programación, Presupuesto y Hacienda Pública por qué el Proyecto de decreto se proporcionó hasta el día de hoy si desde el día 15 de junio se había solicitado.</p>\n" +
                "<p>El diputado pidió la moción a fin de que todos tuvieran la información necesaria expresando que “todos desearíamos que se votara con conocimiento de causa y no por una sumatoria de votos por mayorías\".</p>\n" +
                "<p>Solo 7 legisladores votaron a favor de esta moción, por tanto, fue desechada. </p>\n" +
                "<p>Posteriormente la diputada del PRD, Mónica Rivera expresó su posicionamiento en un discurso contradictorio donde destacó el enorme incremento a la deuda pero finalizó diciendo que su voto sería a favor.</p>\n" +
                "<p>El diputado del PAN Guillermo Loya también pidió el uso de la voz para manifestarse en contra de la aprobación del decreto, señalando que con los antecedentes ya conocidos no era justo aprobar un nuevo endeudamiento.</p>\n" +
                "<p>Por último, Rodrigo de la Rosa habló a los legisladores pidiendo que se dejen de lado los intereses políticos y se votara en pro de la ciudadanía.</p>\n" +
                "<p>“Solicito a los diputados dejar de lado las cuestiones políticas y ser mas responsables con lo que ya aprobaron, con lo que ya discutimos y ver por el futuro de Chihuahua, por las futuras generaciones\", puntualizó.</p>";
        assertEquals(content, this.article.getContent());
    }

    @Test
    public void itShouldGetTheCategory() {
        assertEquals("Nota", this.article.getCategory());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("Ivette", this.article.getAuthor());
    }

    @Test
    public void itShouldGetTheDate() {
        assertEquals("Jul 6, 2016 - 3:43:18 pm", this.article.getDate());
    }

}
