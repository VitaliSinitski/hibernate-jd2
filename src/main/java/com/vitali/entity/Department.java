package com.vitali.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Department implements Serializable {
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "department_id", unique = true)
    private Integer departmentId;
    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employee = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }
}
