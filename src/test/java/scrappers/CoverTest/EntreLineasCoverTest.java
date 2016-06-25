package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.EntreLineasCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/20/16.
 */
public class EntreLineasCoverTest extends StubService implements CommonCoverTest {

    private String url = EntreLineasCover.page;
    private HashSet<String> hash;
    private CoverPage cover;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubEntreLineasCover.html", this.url);
        cover = new EntreLineasCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "http://entrelineas.com.mx/local/inicia-curso-centro-cultural-universitario-quinta-gameros-y-su-historia/";
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
