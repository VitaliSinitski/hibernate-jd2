package com.vitali.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails implements Serializable {
    @Id
    @GenericGenerator(name = "one-one",
    strategy = "foreign",
    parameters = @Parameter(name = "property",
    value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String state;
    @Column
    private String street;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Employee employee;

    @Override
    public String toString() {
        return "EmployeeDetails{" +
               "employeeId=" + employeeId +
               ", city='" + city + '\'' +
               ", country='" + country + '\'' +
               ", state='" + state + '\'' +
               ", street='" + street + '\'' +
               ", employee=" + employee +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetails that = (EmployeeDetails) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
