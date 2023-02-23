package com.vitali.entity;

import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateDate;
}
