package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.OmniaCover;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class OmniaCoverTest {

    private OmniaCover cover;
    private HashSet<String> hash;

    @Before
    public void setup(){
        cover = new OmniaCover();
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "/noticia/respalda-pedro-dominguez-a-dowell-en-impugnacion-del-pri";
        assertTrue(cover.isLink(one));
        String two = "/noticia/respalda-pedro-dominguez-a-dowell-en-impugnacion-del-pri/asD/asd";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
