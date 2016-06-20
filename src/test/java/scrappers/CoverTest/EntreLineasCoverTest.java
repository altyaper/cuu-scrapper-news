package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.EntreLineasCover;
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
 * Created by echavez on 6/20/16.
 */
public class EntreLineasCoverTest implements CommonCoverTest {

    private String url = EntreLineasCover.page;
    private HashSet<String> hash;
    private CoverPage cover;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubEntreLineasCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

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
