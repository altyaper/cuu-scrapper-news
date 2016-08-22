package hibernate;

import utils.UtilFunctions;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by echavez on 7/14/16.
 */
@Entity
@Table(name = "tags", uniqueConstraints = {
        @UniqueConstraint(columnNames = "tag_id")
})
public class TagModel extends AbstractTimestampEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", unique = true)
    private int tagId;

    @Column(nullable = false, unique = true)
    private String name;

    public ArticleModel getArticles() {
        return articles;
    }

    public String getSlug() {
        return slug;
    }

    private void setSlug(String slug) {
        this.slug = UtilFunctions.makeSlug(slug);
    }

    private String slug;

    public void setArticles(ArticleModel articles) {
        this.articles = articles;
    }

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleModel articles;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setSlug(name);
        this.name = name;
    }
}
