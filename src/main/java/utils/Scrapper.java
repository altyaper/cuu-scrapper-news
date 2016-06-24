package utils;

import models.Article;
import scrappers.scrapperPage.*;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 5/20/16.
 */
public final class Scrapper {

    private String url;
    private Article article;

    public Article getArticle() {
        return article;
    }

    public Scrapper(String url) throws IOException {

        article = getObjectArticle(url);

    }

    //Factory Design Pattern
    private Article getObjectArticle(String url) throws IOException {
        if (url.matches(".*tiempo.com.mx.*")) {

            return new Tiempo(url, new HtmlProcess());

        } else if (url.matches(".*laopcion.com.mx.*")) {

            return new Opcion(url, new HtmlProcess());

        } else if (url.matches(".*segundoasegundo.com.*")) {

            return new Segundoasegundo(url, new HtmlProcess());

        } else if (url.matches(".*cronicadechihuahua.com.*")) {

            return new Cronica(url, new HtmlProcess());

        } else if (url.matches(".*nortedigital.mx.*")) {

            return new NorteDigital(url, new HtmlProcess());

        } else if (url.matches(".*chihuahuanoticias.com.*")) {

            return new Chihuahuanoticias(url, new HtmlProcess());

        } else if (url.matches(".*laparadadigital.com.*")) {

            return new ParadaDigital(url, new HtmlProcess());

        } else if (url.matches(".*entrelineas.com.mx.*")) {

            return new EntreLineas(url, new HtmlProcess());

        } else if (url.matches(".*eldiariodechihuahua.mx.*")) {

            return new Diario(url, new HtmlProcess());

        }

        return null;
    }

}
