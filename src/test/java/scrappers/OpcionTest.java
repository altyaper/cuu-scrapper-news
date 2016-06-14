package scrappers;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import models.Video;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by echavez on 5/23/16.
 */
public class OpcionTest {

    Opcion opcion;

    @Before
    public void setup(){
        opcion = new Opcion("http://laopcion.com.mx/noticia/137807/acusan-a-director-de-transporte-de-meter-30-urbanos-chatarra-");
    }

    @Test
    public void itShouldSetTheTitleOfTheArticle(){

        assertEquals("Acusan a Director de Transporte de meter 30 urbanos chatarra", opcion.getTitle());

    }

    @Test
    public void itShouldSetTheContentOfTheArticle(){

        assertEquals("Chihuahua.- Los concesionarios del transporte público cetemistas Francisco Lozoya y Norma Aguirre, denunciaron que las 30 unidades que están resguardadas en el Complejo Estatal de Seguridad, son pertenecientes al Director de Transporte, Gustavo Morales. En este mismo sentido, explicó que estas unidades son tipo maquila que funcionan con motor automático, y que además tienen baratas de disco, con lo cual no podrían funcionar en un correcto frenado, lo que podría generar una desgracia. Fracisco Lozoya reiteró que en lo personal, esos camiones los trajo el director de transporte, los cuales vienen en apoyo al sistema pero que lo mejor es que no hallan ingresado, ya que por el sistema de frenado que tienen, se podría correr alguna desgracia. Se comprometieron a que si establecen una tarifa justa en las nuevas rutas de camiones que se meterán en los próximos días, ellos se comprometen ante un notario a comprar 20 nuevas unidades para meterlas a funcionar en las rutas alimentadoras, esperando entre 6 y 7 semanas a que lleguen los camiones. Francisco Lozoya reiteró que ellos con su propio recurso han ido levantando las unidades que estaban en mal estado, sin recibir recurso alguno para este proyecto.", opcion.getContent());

    }

    @Test
    public void itShouldSetTheAuthorOfTheArticle(){

        assertEquals("Federico Martínez Vargas", opcion.getAuthor());

    }

    @Test
    public void itShouldSetTheThumbnailOfTheArticle(){
        List<String> hash = new ArrayList<String>();

        hash.add("http://laopcion.com.mx/assets/2016/may/23/fqJ3GvLG13eM.jpeg");

        assertEquals(hash, opcion.getThumbnail());

    }

    @Test
    public void itShouldSetTheVideoOfTheArticle(){

        Video video = new Video("http://www.youtube.com/embed/nml8-us2PoA");

        assertEquals(video.getVideoId(), opcion.getVideo().getVideoId());
        assertEquals(video.getProvider(), opcion.getVideo().getProvider());
        assertEquals(video.getUrl(), opcion.getVideo().getUrl());
        assertEquals(video.getClass(), opcion.getVideo().getClass());

    }



}
