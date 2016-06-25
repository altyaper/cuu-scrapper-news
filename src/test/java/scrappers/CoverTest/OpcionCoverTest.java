package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.OpcionCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class OpcionCoverTest extends StubService implements CommonCoverTest{

    public String url = OpcionCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubOpcionCover.html", this.url);
        cover = new OpcionCover(htmlProcessStub);
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
