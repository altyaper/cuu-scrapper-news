package hibernate;

import org.hibernate.annotations.*;
import utils.UtilFunctions;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articles")
public class ArticleModel extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",  unique = true, nullable = false)
    private int id;

    @Column(nullable=false)
    private String title;

    @Type(type = "text")
    private String thumbnail;


    @Column(nullable = false)
    private String slug;

    @Type(type = "timestamp")
    private Date date;

    private String author;

    private String category;

    @Column(name = "source_id")
    private int sourceId;

    @OneToMany(mappedBy = "articles")
    private List<TagModel> tags = new ArrayList<>();

    @Type(type="text")
    @Column(nullable = false)
    private String content;

    @Column(unique = true)
    private String url;

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public List<TagModel> getTags() {
        return tags;
    }

    public void setTags(List<TagModel> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getArticleId() {
        return id;
    }

    public void setArticleId(int articleId) {
        this.id = articleId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String title) throws URISyntaxException {
        String pageName = this.getPage(this.getUrl());
        this.slug = UtilFunctions.makeSlug(title + "-" + pageName);
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws URISyntaxException {
        this.setSlug(title);
        this.title = title;
    }

    @Override
    @Transient
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleModel that = (ArticleModel) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
        if (slug != null ? !slug.equals(that.slug) : that.slug != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    @Transient
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Transient
    public String getPage(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "articleId=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", slug='" + slug + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
