package scrappers.scrapperCover;

import enums.PagesList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scrappers.scrapperPage.Opcion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/16/16.
 */
public class OpcionCover extends CoverPage {

    private Set<String> links = new HashSet<String>();
    private final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.OPCION);
    private final String regex = new String("http:\\/\\/\\w+.com.mx\\/noticia\\/\\d+\\/[0-9a-z-]+");

    public OpcionCover() {
        super(page);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
