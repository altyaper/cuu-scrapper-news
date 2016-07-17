package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by echavez on 7/16/16.
 */
@Entity (name = "categories")
public class CategoryModel {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private int categoryId;
    private String name;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getNme() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
