package scrappers;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by echavez on 6/14/16.
 */
public class ChihuahuanoticiasTest {

    Chihuahuanoticias chihuahua;

    @Before
    public void setup() {
        chihuahua = new Chihuahuanoticias("http://chihuahuanoticias.com/?p=126269");
    }


    @Test
    public void itShouldSetThumbnail() {

        Set<String> thumbnails = new HashSet<String>();
        thumbnails.add("http://chihuahuanoticias.com/wp-content/uploads/2016/06/dfasdfs1.jpg");
        assertEquals(thumbnails, chihuahua.getThumbnail());


    }

    @Test
    public void itShouldSetTitle() {
        assertEquals("Se reúne Miguel Riggs con Hector Barraza", chihuahua.getTitle());
    }

    @Test
    public void itShouldSetContent() {

    }

}