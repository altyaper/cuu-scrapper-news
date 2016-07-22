package hibernate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by echavez on 7/17/16.
 */
@MappedSuperclass
public class AbstractTimestampEntity {

    @Column(name = "created_at", nullable = false)
    private Date created = new Date();

    @Column(name = "updated_at", nullable = false)
    private Date updated = new Date();

    @PreUpdate
    public void setLastUpdate() {  this.updated = this.created = new Date(); }
}
