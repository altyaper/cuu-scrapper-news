package scrappers.scrapperCover;

import enums.PagesList;
import scrappers.scrapperCover.CoverPage;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public class EntreLineasCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.ENTRELINEAS);
    public final String regex = new String("http:\\/\\/entrelineas.com.mx\\/local\\/[\\w+-]+\\/?");

    public EntreLineasCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }

}
