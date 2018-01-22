package scrappers.PageTest;

import models.Article;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Omnia;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/15/16.
 */
public class OmniaTest extends StubService implements CommonTest{

    public String url = "http://www.omnia.com.mx/article/cae-lluvia-en-la-capital-deja-encharcamientos";
    public Article article;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubOmnia.html", this.url);
        article = new Omnia(this.url, htmlProcessStub);

    }

    @Test
    public void itShouldGetTheThumbnail(){
        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://www.omnia.com.mx/sites/default/files/styles/472x332/public/field/image/IMG_2585.JPG?itok=PjW0p7OL");
        assertEquals(thumbnails,article.getThumbnail());
    }


    @Test
    @Override
    public void itShouldGetTheTitle() {
        assertEquals("Cae lluvia en la capital; deja encharcamientos",article.getTitle());

    }

    @Test
    @Override
    public void itShouldGetTheContent() {
        assertEquals("Una buena cantidad de agua cayo esta tarde de manera moderada en toda la mancha urbana, dejando encharcamientos e inundaciones en distintas vialidades. Desde las 17:00 horas se estuvieron presentando las precipitaciones en la salida a Cuauhtémoc y en la zona de Sacramento, pero para aproximadamente las 18:00 horas se generalizo en la mayoría de la capital. Por momentos la lluvia cayó fuertemente, pero la mayoría del tiempo lo hizo de manera moderada por más de 3 horas seguidas, lo que ocasiono que vialidades como: La Antonio de Montes; el periférico Ortiz Mena; la avenida Universidad; la avenida Tecnológico; la avenida Juan Escutia, avenida Equus; avenida Nueva España; entre otras, acumularan cantidades grandes del líquido, generándose caos vial. Hasta el momento el H. cuerpo de bomberos se mantiene pendiente para prestar servicios en cuanto la ciudadanía lo necesite, no se han reportado derrumbes ni inundaciones habitaciones, sin embargo, las autoridades exhortan a tomar las debidas precauciones. Por su parte la dirección de vialidad y tránsito activo unidades para recorrer las arterias principales en operativo de seguridad.",article.getContent());
    }

    @Test
    public void itShouldGetTheAuthor() {
        assertEquals("xavier_ochoa", article.getAuthor());
    }

    @Test
    public void itShouldGetTheDate() {
        Date expectedDate = new Date("Sun Aug 21 19:41:00 UTC 2016");
        assertEquals(expectedDate, article.getDate());
    }
}
