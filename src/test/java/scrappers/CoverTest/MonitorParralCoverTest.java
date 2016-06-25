package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.MonitorParralCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/25/16.
 */
public class MonitorParralCoverTest extends StubService implements CommonCoverTest {

    public String url = MonitorParralCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubMonitorParralCover.html", this.url);
        cover = new MonitorParralCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }


    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "notas.pl?n=82014";
        assertTrue(cover.isLink(one));
        String two = "notas.pl?n=category";
        assertFalse(cover.isLink(two));

    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {
        assertTrue(hash.size() > 0);
    }
}