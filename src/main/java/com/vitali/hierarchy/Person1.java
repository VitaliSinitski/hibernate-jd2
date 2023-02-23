package com.vitali.hierarchy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Person1")
public class Person1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    })
    @Embedded
    private Address address;
    @Embedded
    private Address addressHome;
}
