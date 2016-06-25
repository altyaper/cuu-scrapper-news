package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.ParadaDigitalCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/20/16.
 */
public class ParadaDigitalCoverTest extends StubService implements CommonCoverTest{

    public String url = ParadaDigitalCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubParadaDigitalCover.html", this.url);
        cover = new ParadaDigitalCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "noticias-de-chihuahua-mexico.cfm?n=72084";
        assertFalse(cover.isLink(one));
        String one2 = "/noticias-de-chihuahua-mexico.cfm?n=72084";
        assertTrue(cover.isLink(one2));
        String two = "http://laparadadigital.com/noticias-de-chihuahua-mexico.cfm?n=HELLO";
        assertFalse(cover.isLink(two));
    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }

}
