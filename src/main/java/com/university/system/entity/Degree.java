package com.university.system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "degrees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}