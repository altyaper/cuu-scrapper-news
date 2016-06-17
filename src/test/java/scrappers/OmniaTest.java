package scrappers;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperPage.Omnia;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 6/15/16.
 */
public class OmniaTest {

    Omnia omnia;

    @Before
    public void setup(){

        omnia = new Omnia("http://www.omnia.com.mx/noticias/mundo-obama-agradece-apoyo-a-hollande-por-matanza-de-orlando/");

    }

    @Test
    public void setTitle(){
        assertEquals("MUNDO: Obama agradece apoyo a Hollande por matanza de Orlando",omnia.getTitle());
    }

    @Test
    public void setContent(){

        assertEquals("",omnia.getContent());
    }

    @Test
    public void setThumbnail(){
        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://mdx.omnia.com.mx/media/fotos/20160614_2016-06-14_07-06-55___2799.jpg");
        assertEquals(thumbnails,omnia.getThumbnail());
    }




}
