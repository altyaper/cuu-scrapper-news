package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.PolakaCover;
import scrappers.scrapperCover.CoverPage;
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
 * Created by echavez on 6/24/16.
 */
public class PolakaCoverTest implements CommonCoverTest {

    public String url = PolakaCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubPolakaCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

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
