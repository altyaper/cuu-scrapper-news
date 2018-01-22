package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;
import utils.UtilFunctions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 6/20/16.
 */
public class ParadaDigital extends Article {

    public ParadaDigital(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
        setSourceId(12);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select("article .imgpost img");
        if(!aux.isEmpty()){
            this.thumbnail.add(PagesList.getRootUrls().get(PagesList.pages.PARADADIGITAL)+aux.get(0).attr("src").toString().substring(1));
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("header h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("article .post-content > p");
        this.content = aux.outerHtml().replace("Descarga nuestra Aplicación móvil", "");
    }

    @Override
    public void setDate(){
        Elements aux = this.html.select(".postmeta .meta-date");
        String dateString = aux.text().trim().substring(0, aux.text().length()-1);
        String[] parts = dateString.split(" ");
        String days = parts[0];
        String month = UtilFunctions.getMonthBySpanishName(parts[2]);
        String year = parts[parts.length-1];
        String finalString = days + "/" + month + "/" + year;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.date = format.parse(finalString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
