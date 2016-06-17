package scrappers.scrapperCover;

import enums.PagesList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/17/16.
 */
public class SegundoasegundoCover extends CoverPage {

    protected final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.SEGUNDOASEGUNDO);
    public final String regex = new String("[0-9a-zA-Z-]+,\\d+.html");

    public SegundoasegundoCover() {
        super(page);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
