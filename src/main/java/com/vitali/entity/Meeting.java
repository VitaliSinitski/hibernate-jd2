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
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private Integer meetingId;
    @Column(name = "first_name")
    private String firstName;
    @ManyToMany(mappedBy = "meetings")
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(meetingId, meeting.meetingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId);
    }
}
