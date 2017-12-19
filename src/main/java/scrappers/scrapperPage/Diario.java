package scrappers.scrapperPage;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/23/16.
 */
public class Diario extends Article {
    public Diario(String url, HtmlProcess htmlProcessStub) throws IOException {
        super(url, htmlProcessStub);
        setCategory();
        setSourceId(4);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select("#img_ppal img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src").toString());
        }else{
            aux = this.html.select("meta");
            for(Element meta: aux){
                if(meta.attr("property").equals("og:image")){
                    this.thumbnail.add(meta.attr("content"));
                }
            }
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("#texto_nota");
        this.content = Jsoup.clean(aux.html(), Whitelist.basic());
    }

    @Override
    public void setCategory(){
        Elements aux = this.html.select(".nota_seccion .center_div1000");
        this.category = aux.text().trim();
    }


}
