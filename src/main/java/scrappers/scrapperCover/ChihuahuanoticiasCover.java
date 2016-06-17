package scrappers.scrapperCover;

import enums.PagesList;
import org.w3c.dom.html.HTMLTableRowElement;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/17/16.
 */
public class ChihuahuanoticiasCover extends CoverPage {

    protected final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.CHIHUAHUANOTICIAS);
    private final String regex = new String("http:\\/\\/chihuahuanoticias.com\\/\\?p=\\d+");

    public ChihuahuanoticiasCover() {
        super(page);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
