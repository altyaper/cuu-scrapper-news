package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.RedNoticiasCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/26/16.
 */
public class RedNoticiasCoverTest extends StubService implements CommonCoverTest {


    private CoverPage cover;
    private HashSet<String> hash;
    private String url = RedNoticiasCover.page;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubRedNoticiasCover.html", this.url);
        cover = new RedNoticiasCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "/noticias.cfm?n=179423";
        assertTrue(cover.isLink(one));
        String two = "/noticia/lunes_consejo_politico_del_pri/1";
        assertFalse(cover.isLink(two));

    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {
        assertTrue(hash.size() > 0);
    }
}
