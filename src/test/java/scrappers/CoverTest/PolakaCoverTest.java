package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.PolakaCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/24/16.
 */
public class PolakaCoverTest extends StubService implements CommonCoverTest {

    public String url = PolakaCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubPolakaCover.html", this.url);
        cover = new PolakaCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "http://www.lapolaka.com/viernesnegro-al-100/";
        assertFalse(cover.isLink(one));
        String two = "http://www.lapolaka.com/contacto/";
        assertFalse(cover.isLink(two));

    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {

        assertTrue(hash.size() > 0);

    }
}
