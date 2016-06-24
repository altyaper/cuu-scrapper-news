package scrappers.scrapperCover;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by echavez on 6/15/16.
 */
public abstract class CoverPage {

    public Document html;
    public String url;

    public CoverPage(String url, HtmlProcess htmlProcess) throws IOException {
        this.url = url;
        this.html = htmlProcess.getHtml(url);
    }

    public abstract boolean isLink(String href);

    public HashSet<String> getArticlesLinks(){
        HashSet<String> auxlinks = new HashSet<String>();

        Elements elements = this.html.select("a");

        for(Element link: elements){
            String stringLink = link.attr("href");

            if(this.isLink(stringLink)){

                auxlinks.add(stringLink);

            }
        }
        return auxlinks;
    }

    private boolean setHTML(){

        Document doc = null;
        try {
            this.html = Jsoup.connect(this.url).get();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            return false;
        }

    }

    public Document getHtml() {
        return html;
    }


}
