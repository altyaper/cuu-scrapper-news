package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.ChihuahuanoticiasCover;
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
public class ChihuahuanoticiasCoverTest {

    public String url = ChihuahuanoticiasCover.page;
    private ChihuahuanoticiasCover cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubChihuahuanoticiasCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cover = new ChihuahuanoticiasCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "http://chihuahuanoticias.com/?p=126585";
        assertTrue(cover.isLink(one));
        String two = "http://chihuahuanoticias.com/sdaf/?p=126585";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }
}
