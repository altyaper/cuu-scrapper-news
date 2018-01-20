package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by echavez on 6/25/16.
 */
public class MonitorParral extends Article {

    public MonitorParral(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setAuthor();
        setDate();
        setSourceId(8);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select(".titulo_interno");
        this.title = this.capitalize(aux.text().trim().toLowerCase());
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".nota-contenido");
        this.content = aux.outerHtml();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".img-thumbnail");
        if(!aux.isEmpty())
            this.thumbnail.add(PagesList.getRootUrls().get(PagesList.pages.MONITORPARRAL) + aux.attr("src").substring(1, aux.attr("src").length()));
    }

    public void setAuthor() {
        Elements aux = this.html.select(".nota-autor-fecha");
        Pattern p = Pattern.compile("(: *.+ \\|)");
        Matcher m = p.matcher(aux.text().trim());
        if (m.find()) {
            this.author = m.group().substring(2, m.group().length() - 2);
        }
    }

    public void setDate() {
        Elements aux = this.html.select(".nota-autor-fecha");
        Pattern p = Pattern.compile("Fecha: *.+");
        Matcher m = p.matcher(aux.text().trim());
        if (m.find()) {
            this.date = new Date();
//            this.date = m.group().replace("Fecha: ", "");
        }
    }
}
