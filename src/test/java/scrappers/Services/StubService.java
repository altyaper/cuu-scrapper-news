package scrappers.Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import services.HtmlProcess;

import java.io.File;
import java.io.IOException;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

/**
 * Created by echavez on 6/25/16.
 */
public abstract class StubService {

    public HtmlProcess getAndSetStub(String filename, String url) throws IOException {

        HtmlProcess htmlProcessStub = createMock(HtmlProcess.class);
        String dir = getClass().getResource(filename).toString().replace("file:", "");
        File file = new File(dir);
        Document document = Jsoup.parse(file, "UTF-8", url);
        expect(htmlProcessStub.getHtml(url)).andStubReturn(document);
        replay(htmlProcessStub);

        return htmlProcessStub;

    }
}
