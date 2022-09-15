package com.example.absencespring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Relation;
import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"users\"")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Users implements Serializable {
    public static final Relation TEACHER = TEACHER;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String ref;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(length = 1, nullable = false)
    private char sex;

    private String birthDate;

    private String address;

    @Column(length = 10)
    private String phoneNumber;

    @Column(unique = true)
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private UserType type;

    @ManyToOne
    private StudentGroup group;
}
