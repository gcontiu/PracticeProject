package practice.model;

import javax.persistence.*;
import java.io.Serializable;

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
    private String name;

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
}
