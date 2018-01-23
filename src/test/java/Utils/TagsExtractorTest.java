package Utils;

import clover.it.unimi.dsi.fastutil.Hash;
import models.Article;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperPage.Ahoramismo;
import services.HtmlProcess;
import utils.TagsExtractor;

import java.io.IOException;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 1/22/18.
 */
public class TagsExtractorTest  extends StubService {

    public TagsExtractor tagsExtractor;
    public Ahoramismo article;
    public String url = "http://ahoramismo.mx/hallan-a-pareja-ejecutada-al-sur-de-la-ciudad/";


    @Before
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubPage/stubAhoramismo.html", this.url);
        article = new Ahoramismo(this.url, htmlProcessStub);
        tagsExtractor = new TagsExtractor(article);
    }

    @Test
    public void itShouldLoadAFile() {

        this.tagsExtractor = new TagsExtractor(this.article);
        Set<String> stopWords = tagsExtractor.loadStopWords("es");
        assert(stopWords.size() > 0);

    }

    @Test
    public void itShouldStickTheArticleParts() {

        String expectedString = "Hallan a pareja ejecutada al sur de la ciudad LaRedacción Los cadáveres de un hombre y una mujer fueron localizados tirados en un paraje solitario al sur de la ciudad de Chihuahua en las colindancias con el municipio de Aquiles Serdán. Personas que caminaban por detrás de la planta productora Vitromex fueron quienes reportaron a los números de emergencia el hallazgo de ambos cadáveres por lo que policías de ambos municipios atendieron el llamado. La escena del crimen fue asegurada y se confirmó la presencia de un cadáver masculino y otro femenino ambos con huellas de violencia externa al parecer con impactos de bala en diferentes partes del cuerpo. El hallazgo fue realizado alrededor de las 05:00 horas de este sábado y personal del Servicio Médico Forense se encargó de levantar los cadáveres y trasladarlos a las instalaciones del Complejo de Seguridad Pública Estatal para la práctica de la necropsia de ley y el protocolo de identificación. Foto: archivo";

        String stickContent = this.tagsExtractor.getStickContent();

        assertEquals(expectedString, stickContent);

    }

    @Test
    public void itShouldReturnTheTags() {
        Set<String> finalSet = this.tagsExtractor.processContent();
        System.out.println("hjo");
    }

}
