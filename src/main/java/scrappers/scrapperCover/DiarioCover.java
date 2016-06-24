package scrappers.scrapperCover;

import enums.PagesList;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/23/16.
 */
public class DiarioCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.DIARIO);
    public final String regex = new String("\\w+:\\/\\/\\w+.\\w+\\/\\w+[\\/\\d]+[\\w+-]+\\/?");

    public DiarioCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    @Override
    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
