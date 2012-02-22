package practice.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * User: gelu
 * Date: 1/20/12
 * Time: 8:07 PM
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "Industry")
    @Enumerated(EnumType.STRING)
    private Industry industry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
}


