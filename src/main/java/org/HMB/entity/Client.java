package org.HMB.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String name;
}
