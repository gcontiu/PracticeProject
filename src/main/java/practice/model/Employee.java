package practice.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 1/20/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "employees")
@Validated
public class Employee implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
