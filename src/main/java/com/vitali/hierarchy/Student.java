package com.vitali.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue("S")
@Entity
@Table
public class Student extends Person1{
    @Column(name = "faculty_univer")
    private String faculty;
    private Double mark;
}
