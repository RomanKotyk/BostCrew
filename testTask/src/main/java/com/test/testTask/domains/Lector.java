package com.test.testTask.domains;

import com.test.testTask.enums.TypeLector;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/***
 * Lector domain
 */
@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private Double salary;
    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private TypeLector degree;
    @ManyToMany(mappedBy = "lectors")
    private List<Department> departmentList = new ArrayList<>();


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public TypeLector getDegree() {
        return degree;
    }

    public void setDegree(TypeLector degree) {
        this.degree = degree;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        salary = salary;
    }

    @Override
    public String toString() {
        return name + " "  + surname;
    }
}
