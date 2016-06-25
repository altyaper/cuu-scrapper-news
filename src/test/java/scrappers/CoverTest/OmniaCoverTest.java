package scrappers.CoverTest;

import org.junit.Before;
import org.junit.Test;
import scrappers.Services.StubService;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.OmniaCover;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class OmniaCoverTest extends StubService implements CommonCoverTest{

    public String url = OmniaCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = this.getAndSetStub("/stubCover/stubOmniaCover.html", this.url);
        cover = new OmniaCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "/noticia/respalda-pedro-dominguez-a-dowell-en-impugnacion-del-pri";
        assertTrue(cover.isLink(one));
        String two = "/noticia/respalda-pedro-dominguez-a-dowell-en-impugnacion-del-pri/asD/asd";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
