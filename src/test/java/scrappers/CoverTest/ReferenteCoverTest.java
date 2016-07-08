package scrappers.CoverTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

import scrappers.scrapperCover.ReferenteCover;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import services.HtmlProcess;

/**
 * Created by echavez on 7/6/16.
 */
public class ReferenteCoverTest extends StubService implements CommonCoverTest {

    private CoverPage cover;
    private HashSet<String> hash;
    private String url = ReferenteCover.page;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubReferenteCover.html", this.url);
        cover = new ReferenteCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "http://referente.mx/@Ivette/diputados-aprueban-nueva-deuda-de-6-mil-millones-de-pesos";
        assertTrue(cover.isLink(one));
        String two = "http://referente.mx/@Ivette/otro/diputados-aprueban-nueva-deuda-de-6-mil-millones-de-pesos";
        assertFalse(cover.isLink(two));
    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {
        assertTrue(hash.size() > 0);
    }
}
