package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Futuro;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by echavez on 6/29/16.
 */
public class FuturoTest extends StubService implements CommonTest {

    public String url = "http://www.futuro.mx/nota.php?recordID=26914";
    public Article article;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubFuturo.html", this.url);
        article = new Futuro(this.url, htmlProcessStub);
    }

    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Inaugura Garfio techumbre en la primaria Revolución 2653", this.article.getTitle());
    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("Mejores condiciones para realizar sus actividades deportivas y escolares tienen los alumnos de la Primaria “Revolución 2653” gracias a la colocación de techumbre y mejora de las instalaciones.<br> <br> Así lo resaltó el alcalde Javier Garfio Pacheco en su visita a esta escuela ubicada en la colonia Solidaridad, al norte de la capital del estado, durante la cual felicitó a los alumnos, maestros y padres de familia por esta mejora en las instalaciones.<br> En la primaria se invirtió un total de 860 mil pesos gracias a la colaboración por partes iguales entre el gobierno municipal y federal, con lo que se colocó techumbre de 252 metros cuadrados. Además se colocó canasta y portería en la cancha, barandal, pintura e impermeabilización en salones.<br> Con estas obras se benefició a 270 alumnos y 21 personas entre docentes y personal de la institución quienes con un gran aplauso mostraron su felicidad por las mejoras en su escuela, pues es así como se construye futuro.<br>", this.article.getContent());
    }

    @Test
    public void itShouldGetTheThumbnail() {
        Set<String> thumbnails = new HashSet<>();
        thumbnails.add("http://www.futuro.mx/noticias/garfio-canasta.jpg");
        assertEquals(thumbnails, this.article.getThumbnail());
    }

    @Test
    public void itShouldGetTheDate(){
        assertEquals("28/Junio/2016", this.article.getDate());
    }


}
