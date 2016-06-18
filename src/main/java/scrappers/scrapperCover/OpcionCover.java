package scrappers.scrapperCover;

import enums.PagesList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scrappers.scrapperPage.Opcion;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/16/16.
 */
public class OpcionCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.OPCION);
    public final String regex = new String("http:\\/\\/\\w+.com.mx\\/noticia\\/\\d+(\\/[0-9a-z-]+)?");

    public OpcionCover(HtmlProcess htmlProcess) throws IOException {
        super(page,htmlProcess);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
