package scrappers.scrapperCover;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import enums.PagesList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/17/16.
 */
public class OmniaCover extends CoverPage {

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.OMNIA);
    public final String regex = new String("\\/article\\/[a-z0-9-ñáéíóú]+");

    public OmniaCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }

    @Override
    public HashSet<String> getArticlesLinks(){

        HashSet<String> auxlinks = new HashSet<String>();

        Elements elements = this.getHtml().select("a");

        for(Element link: elements){
            String stringLink = link.attr("href");
            if(this.isLink(stringLink)){
                auxlinks.add(page+stringLink);

            }
        }
        return auxlinks;

    }
}
