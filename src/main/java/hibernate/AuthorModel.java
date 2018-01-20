package hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by echavez on 7/17/16.
 */
@Entity(name = "authors")
public class AuthorModel extends AbstractTimestampEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;

    @OneToOne
    @JoinColumn(name = "id")
    private ArticleModel article;

    @Column(unique = true)
    private String name;

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
