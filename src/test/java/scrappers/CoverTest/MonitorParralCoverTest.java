package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.MonitorParralCover;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by echavez on 6/25/16.
 */
public class MonitorParralCoverTest implements CommonCoverTest {

    public String url = MonitorParralCover.page;
    private CoverPage cover;
    private HashSet<String> hash;

    @Before
    @Override
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubMonitorParralCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cover = new MonitorParralCover(htmlProcessStub);
        hash = cover.getArticlesLinks();
    }


    @Test
    @Override
    public void itShouldMatchWithRegexPattern() {

        String one = "notas.pl?n=82014";
        assertTrue(cover.isLink(one));
        String two = "notas.pl?n=category";
        assertFalse(cover.isLink(two));

    }

    @Test
    @Override
    public void itShouldGetAtLeastOneNew() {
        assertTrue(hash.size() > 0);
    }
}