package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.NorteDigitalCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class NorteDigitalCoverTest extends StubService implements CommonCoverTest{

    public String url = NorteDigitalCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubNorteDigitalCover.html", this.url);
        cover = new NorteDigitalCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "http://nortedigital.mx/la-caza-mapaches-los-nogales/";
        assertTrue(cover.isLink(one));
        String two = "http://nortedigital.mx/la-caza-mapaches-los-nogales/asdad/asdasd";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
