package com.vitali.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table
public class Employee extends DataEntity implements Serializable {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "cell_phone")
    private String cellPhone;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee",
    cascade = CascadeType.ALL)
    @ToString.Exclude
    private EmployeeDetails employeeDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_meeting", joinColumns = {@JoinColumn(name = "employee_id")},
                inverseJoinColumns = {@JoinColumn(name = "meeting_id")})
    @ToString.Exclude
    private Set<Meeting> meetings = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
