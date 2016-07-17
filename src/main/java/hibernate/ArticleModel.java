package hibernate;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.Type;

import java.util.*;

import javax.persistence.*;

@Entity (name = "articles")
public class ArticleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String thumbnail;
    private String author;
    private String date;

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    @OneToOne (cascade = {CascadeType.ALL})
    private CategoryModel category;

    @Type(type="text")
    private String content;

    @OneToMany (cascade = {CascadeType.ALL})
    private Collection<TagModel> tags = new ArrayList<TagModel>();

    private String url;

    private Date created_at;
    private Date updated_at;

    public String getThumbnail() {
        return thumbnail;
    }

    public Collection<TagModel> getTags() {
        return tags;
    }

    public void setTags(Collection<TagModel> tags) {
        this.tags = tags;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
