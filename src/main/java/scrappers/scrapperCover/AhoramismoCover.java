package scrappers.scrapperCover;

import enums.PagesList;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/25/16.
 */
public class AhoramismoCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.AHORAMISMO);
    public final String regex = new String("http:\\/\\/ahoramismo.mx\\/(\\w+-)+(\\w+)\\/?");

    public AhoramismoCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    @Override
    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
