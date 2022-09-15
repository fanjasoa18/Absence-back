package com.example.absencespring.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"courses\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int course_id;

    private String ref;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Users teacher;


}
