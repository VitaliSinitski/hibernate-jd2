package com.vitali.entity;

import lombok.*;
import org.hibernate.Hibernate;

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
@Table
public class Meeting extends DataEntity implements Serializable {

    @Column(name = "first_name")
    private String firstName;
    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(getId(), meeting.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
