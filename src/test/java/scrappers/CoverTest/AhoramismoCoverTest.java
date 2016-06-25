package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.AhoramismoCover;
import scrappers.scrapperCover.CoverPage;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/25/16.
 */
public class AhoramismoCoverTest extends StubService implements CommonCoverTest {

    public String url = AhoramismoCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubAhoramismoCover.html", this.url);
        cover = new AhoramismoCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "http://ahoramismo.mx/hallan-a-pareja-ejecutada-al-sur-de-la-ciudad/";
        assertTrue(cover.isLink(one));
        String two = "http://chihuahuanoticias.com/sdaf/?p=126585";
        assertFalse(cover.isLink(two));

    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {

        assertTrue(hash.size() > 0);

    }
}
