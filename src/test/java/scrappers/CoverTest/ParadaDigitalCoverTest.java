package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.ParadaDigitalCover;
import scrappers.scrapperCover.OpcionCover;
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
 * Created by echavez on 6/20/16.
 */
public class ParadaDigitalCoverTest {

    public String url = ParadaDigitalCover.page;
    private ParadaDigitalCover cover;
    private HashSet<String> hash;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubParadaDigitalCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cover = new ParadaDigitalCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "noticias-de-chihuahua-mexico.cfm?n=72084";
        assertTrue(cover.isLink(one));
        String one2 = "/noticias-de-chihuahua-mexico.cfm?n=72084";
        assertTrue(cover.isLink(one2));
        String two = "http://laparadadigital.com/noticias-de-chihuahua-mexico.cfm?n=HELLO";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }

}
