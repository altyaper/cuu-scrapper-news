package scrappers.scrapperCover;

import enums.PagesList;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/24/16.
 */
public class PolakaCover extends CoverPage{

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.POLAKA);
    public final String regex = new String("http:\\/\\/www.lapolaka.com\\/(\\w+-)(\\w+)\\/?");

    public PolakaCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    @Override
    public boolean isLink(String href) {
        if(href.equals("http://www.lapolaka.com/quienes-somos/"))
            return false;
        return href.matches(this.regex);
    }
}
