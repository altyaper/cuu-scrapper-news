package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.OpcionCover;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class OpcionCoverTest {


    private OpcionCover cover;
    private HashSet<String> hash;

    @Before
    public void setup(){
        cover = new OpcionCover();
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "http://laopcion.com.mx/noticia/140178";
        assertTrue(cover.isLink(one));
        String two = "laopcion.com.mx/noticia/";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }


}
