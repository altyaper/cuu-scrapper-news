package hibernate;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by echavez on 7/16/16.
 */
@Entity
@Table(name = "categories")
public class CategoryModel extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "article_id")
    private ArticleModel article;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getNme() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
