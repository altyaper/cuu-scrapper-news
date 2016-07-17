package hibernate;

import javax.persistence.*;

/**
 * Created by echavez on 7/14/16.
 */
@Entity (name = "tags")
public class TagModel {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue
    private int tagId;
    private String name;
    @ManyToOne
    private ArticleModel article;

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
