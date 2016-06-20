package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.NorteDigitalCover;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/17/16.
 */
public class NorteDigitalCoverTest {

    public String url = NorteDigitalCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubNorteDigitalCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cover = new NorteDigitalCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "http://nortedigital.mx/la-caza-mapaches-los-nogales/";
        assertTrue(cover.isLink(one));
        String two = "http://nortedigital.mx/la-caza-mapaches-los-nogales/asdad/asdasd";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
