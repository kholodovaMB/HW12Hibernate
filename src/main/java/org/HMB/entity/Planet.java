package org.HMB.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private String id;

    @Column(length = 500)
    private String name;

}
