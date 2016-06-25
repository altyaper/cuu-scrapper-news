package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.ChihuahuanoticiasCover;
import scrappers.scrapperCover.CoverPage;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class ChihuahuanoticiasCoverTest extends StubService implements CommonCoverTest{

    public String url = ChihuahuanoticiasCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubChihuahuanoticiasCover.html", this.url);
        cover = new ChihuahuanoticiasCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "http://chihuahuanoticias.com/?p=126585";
        assertTrue(cover.isLink(one));
        String two = "http://chihuahuanoticias.com/sdaf/?p=126585";
        assertFalse(cover.isLink(two));

    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }

}
