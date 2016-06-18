package scrappers.scrapperCover;

import enums.PagesList;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/17/16.
 */
public class NorteDigitalCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.NORTEDIGITAL);
    public final String regex = new String("http:\\/\\/nortedigital.mx\\/\\w+[-][a-zA-Z0-9-]+\\/");

    public NorteDigitalCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
