package models;

/**
 * Created by echavez on 5/20/16.
 */
public class Page {

    private String url;
    private String logo;

    public Page(String url, String logo) {
        this.url = url;
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
