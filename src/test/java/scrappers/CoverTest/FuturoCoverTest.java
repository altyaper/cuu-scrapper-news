package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.FuturoCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/28/16.
 */
public class FuturoCoverTest extends StubService implements CommonCoverTest {

    private String url = FuturoCover.page;
    private HashSet<String> hash;
    private CoverPage cover;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubFuturoCover.html", this.url);
        cover = new FuturoCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {
        String one = "nota.php?recordID=26920";
        assertTrue(cover.isLink(one));
        String two = "http://www.cronicadechihuahua.com/Fuga-de-agua-causada-por-camion-de";
        assertFalse(cover.isLink(two));
    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {
        assertTrue(hash.size() > 0);
    }
}
