package com.test.testTask.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/***
 * Department domain
 */
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "department_lectors",
            joinColumns = { @JoinColumn(name = "department_id") },
            inverseJoinColumns = { @JoinColumn(name = "lector_id") }
    )
    List<Lector> lectors = new ArrayList<>();

    @Column(name = "head_of_department")
    private Long headLectorId;

    public Long getHeadLectorId() {
        return headLectorId;
    }

    public void setHeadLectorId(Long headLectorId) {
        this.headLectorId = headLectorId;
    }

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


    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }
}
