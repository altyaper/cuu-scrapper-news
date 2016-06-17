package scrappers.PageTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Omnia;
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
 * Created by echavez on 6/15/16.
 */
public class OmniaTest {

    public String url = "http://www.omnia.com.mx/noticias/version-grupo-armado-saquea-casa-de-la-madre-de-el-chapo-en-sinaloa/";
    public Omnia omnia;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubOmnia.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        omnia = new Omnia(this.url, htmlProcessStub);

    }

    @Test
    public void setTitle(){
        assertEquals("NACIONAL: Versión: Grupo armado saquea casa de la madre de \"El Chapo\" en Sinaloa",omnia.getTitle());
    }

    @Test
    public void setContent(){

        assertEquals("Ciudad de México. Un comando armado saqueó la casa de Consuelo Loera, madre de Joaquín \"El Chapo\" Guzmán y asesinó al menos a tres personas de la comunidad La Tuna, en el municipio de Badiraguato, Sinaloa. Según informa el diario Ríodoce, los hechos ocurrieron el sábado pasado, cuando unos 150 sujetos fuertemente armados entraron a la comunidad a las 10:00 horas y mataron a balazos a ocho vecinos, aunque sólo se han localizado tres cadáveres. \"Simultáneamente, otro comando entró a la casa de Consuelo Loera, y tomaron dos vehículos conocidas como Razers, y al menos otras tres motocicletas todo terreno, además de cortar líneas telefónicas, y de Internet (sic)\", precisó el diario. Vecinos de las comunidades San José del Barranco y Arroyo Seco también fueron despojados de varios vehículos por hombres armados, situación que los obligó a dejar sus casas y mudarse el domingo a Culiacán y a la cabecera municipal de Badiraguato. Te puede interesar La irrupción de los comandos dejó \"desoladas\" a las comunidades de Arroyo Seco, La Tuna y La Palma, indicó Ríodoce. Fuentes anónimas citadas por el diario atribuyeron el ataque a la organización criminal de los Beltrán Leyva y de Isidro Meza Flores, \"El Chapito\". El diario señala que de acuerdo con una familia entrevistada, ninguna autoridad ha acudido a la región, pese a que se han realizado varias denuncias de los hechos. En tanto, la Secretaría de Seguridad Pública de Sinaloa anunció el miércoles que en conjunto con el Ejército, se implementaría un operativo en la zona para retomar el control, sin embargo hasta el momento no hay reportes oficiales de que esto haya sucedido.",omnia.getContent());
    }

    @Test
    public void setThumbnail(){
        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://mdx.omnia.com.mx/media/fotos/20160616_consuelo.jpg");
        assertEquals(thumbnails,omnia.getThumbnail());
    }




}
