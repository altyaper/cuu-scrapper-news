package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;
import utils.UtilFunctions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 6/26/16.
 */
public class RedNoticias extends Article{

    public RedNoticias(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setCategory();
        setDate();
        setSourceId(15);
    }

    @Override
    public void setThumbnail() {
        String base = (String) PagesList.getRootUrls().get(PagesList.pages.REDNOTICIAS);
        Elements auxe = this.html.select(".head-image img");
        if(!auxe.isEmpty()){
            String src = auxe.attr("src");
            this.thumbnail.add(base+src.substring(1, src.length()));
        }
    }

    @Override
    public void setTitle() {
        this.title = this.html.select("header h1").text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("#article-post .col-sm-9");
        for (Element element : aux.select("header")) {
            element.remove();
        }
        for (Element element : aux.select("script")) {
            element.remove();
        }
        for (Element element : aux.select("fb|comments")) {
            element.remove();
        }
        this.content = aux.html().replace("<!-- end:comments-list -->", "").replace("<!-- start:comments-list --> \n" +
                "<div id=\"fb-root\"></div>","");
    }

    public void setCategory() {
        Elements aux = this.html.select(".breadcrumb li:last-child a");
        this.category = this.capitalize(aux.html().toLowerCase());
    }

    public void setDate() {
        Elements aux = this.html.select("#article-post .col-sm-9 .lead:first-child");
        String dateaux = aux.html();
        String dateString = dateaux.substring(0,dateaux.length()-1);
        String[] parts = dateString.split(" ");
        String monthInt = UtilFunctions.getMonthBySpanishName(parts[2]);
        String year = parts[parts.length-1].replace(".", "");
        String finalString = parts[0] + "/" + monthInt + "/" + year;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.date = format.parse(finalString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        this.date = dateaux.substring(0,dateaux.length()-1);
    }
}
