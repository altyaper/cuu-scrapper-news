package hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by echavez on 7/14/16.
 */
@Entity (name = "tags")
public class TagModel extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int tagId;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private ArticleModel articles;

    public ArticleModel getArticles() {
        return articles;
    }

    public void setArticles(ArticleModel articles) {
        this.articles = articles;
    }

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
        this.name = name;
    }
}
