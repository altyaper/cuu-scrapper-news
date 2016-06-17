package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.CronicaCover;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class CronicaCoverTest {

    private CronicaCover cover;
    private HashSet<String> hash;

    @Before
    public void setup(){
        cover = new CronicaCover();
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "Fuga-de-agua-causada-por-camion-de,44604.html";
        assertTrue(cover.isLink(one));
        String two = "http://www.cronicadechihuahua.com/Fuga-de-agua-causada-por-camion-de";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
