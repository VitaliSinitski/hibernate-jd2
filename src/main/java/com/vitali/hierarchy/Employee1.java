package com.vitali.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue("E")
@Entity
@Table
public class Employee1 extends Person1 {
    private String company;
    private Double salary;
}
