package scrappers.scrapperCover;

import enums.PagesList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by echavez on 6/20/16.
 */
public class ParadaDigitalCover extends CoverPage{

    public final static String page = (String) PagesList.getRootUrls().get(PagesList.pages.PARADADIGITAL);
    public final String regex = new String("\\/noticias-de-chihuahua-mexico.cfm\\?n=\\d+");

    public ParadaDigitalCover(HtmlProcess htmlProcess) throws IOException {
        super(page, htmlProcess);
    }

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

    public boolean isLink(String href) {
        return href.matches(this.regex);
    }
}
