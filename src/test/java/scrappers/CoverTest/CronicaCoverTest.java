package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.CronicaCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class CronicaCoverTest extends StubService implements CommonCoverTest{

    private String url = CronicaCover.page;
    private HashSet<String> hash;
    private CoverPage cover;


    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubCronicaCover.html", this.url);
        cover = new CronicaCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "Fuga-de-agua-causada-por-camion-de,44604.html";
        assertTrue(cover.isLink(one));
        String two = "http://www.cronicadechihuahua.com/Fuga-de-agua-causada-por-camion-de";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
