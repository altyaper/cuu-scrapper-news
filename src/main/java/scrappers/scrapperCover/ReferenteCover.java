package scrappers.scrapperCover;

import java.io.IOException;

import enums.PagesList;
import services.HtmlProcess;

/**
 * Created by echavez on 7/6/16.
 */
public class ReferenteCover extends CoverPage{

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.REFERENTE);
    public final String regex = new String("http:\\/\\/referente.mx\\/@\\w+\\/[a-zA-Z-0-9]+");

    public ReferenteCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    @Override
    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
