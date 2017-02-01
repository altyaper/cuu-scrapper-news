package utils;

import java.io.IOException;

import models.Article;
import scrappers.scrapperPage.*;
import services.HtmlProcess;

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

        } else if (url.matches(".*lapolaka.com.*")) {

            return new Polaka(url, new HtmlProcess());

        } else if (url.matches(".*elmonitorparral.com.*")) {

            return new MonitorParral(url, new HtmlProcess());

        } else if (url.matches(".*ahoramismo.mx.*")) {

            return new Ahoramismo(url, new HtmlProcess());

        } else if (url.matches(".*larednoticias.com.mx.*")) {

            return new RedNoticias(url, new HtmlProcess());

        } else if (url.matches(".*futuro.mx.*")) {

            return new Futuro(url, new HtmlProcess());

        } else if (url.matches(".*informaciontotal.com.mx.*")) {

            return new InformacionTotal(url, new HtmlProcess());

        } else if (url.matches(".*elpueblo.com.*")) {

            return new Pueblo(url, new HtmlProcess());

        } else if (url.matches(".*referente.mx.*")) {

            return new Referente(url, new HtmlProcess());

        } else if (url.matches(".*omnia.com.mx.*")) {

            return new Omnia(url, new HtmlProcess());

        }


        return null;
    }

}
