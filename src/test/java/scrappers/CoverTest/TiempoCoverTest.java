package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.TiempoCover;
import static org.junit.Assert.*;
import java.util.HashSet;

/**
 * Created by echavez on 6/17/16.
 */
public class TiempoCoverTest {

    private TiempoCover cover;
    private HashSet<String> hash;

    @Before
    public void setup(){



        cover = new TiempoCover();
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "/noticia/39072-lunes_consejo_politico_del_pri/1";
        assertTrue(cover.isLink(one));
        String two = "/noticia/lunes_consejo_politico_del_pri/1";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }


}
