package com.example.absencespring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private String type;


}

