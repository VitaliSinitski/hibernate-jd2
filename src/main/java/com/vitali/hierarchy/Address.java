package com.vitali.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address implements Serializable {
    @Column(name = "street_id")
    private String street;
    private String city;

}
