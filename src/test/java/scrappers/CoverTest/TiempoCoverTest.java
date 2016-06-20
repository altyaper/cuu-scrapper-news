package scrappers.CoverTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import scrappers.scrapperCover.CoverPage;
import scrappers.scrapperCover.TiempoCover;
import services.HtmlProcess;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by echavez on 6/17/16.
 */
public class TiempoCoverTest {

    private CoverPage cover;
    private HashSet<String> hash;
    private String url = TiempoCover.page;

    @Before
    public void setup() throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource("/stubCover/stubTiempoCover.html").toString().replace("file:","");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8",this.url);
        expect(htmlProcessStub.getHtml(this.url)).andStubReturn(document);
        replay(htmlProcessStub);

        cover = new TiempoCover(htmlProcessStub);
        hash = cover.getArticlesLinks();

    }

    @Test
    public void itShouldMatchWithRegexPattern(){

        String one = "/noticia/39072-lunes_consejo_politico_del_pri/1";
        assertTrue(cover.isLink(one));
        String two = "/noticia/lunes_consejo_politico_del_pri/1";
        assertFalse(cover.isLink(two));
    }

    @Test
    public void itShouldGetAtLeastOneNew(){

        assertTrue(hash.size() > 0);

    }


}
