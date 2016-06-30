package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.InformacionTotalCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/30/16.
 */
public class InformacionTotalCoverTest extends StubService implements CommonCoverTest {

    private String url = InformacionTotalCover.page;
    private HashSet<String> hash;
    private CoverPage cover;

    @Before
    @Override
    public void setup() throws IOException {
        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubInformacionTotalCover.html", this.url);
        cover = new InformacionTotalCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {
        String one = "/2016-06-29-df0de1a5/ine-recibe-indforme-de-ingresos-y-gastos-de-campana-de-952-de-candidatos/";
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
