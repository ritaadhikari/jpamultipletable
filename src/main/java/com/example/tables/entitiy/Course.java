package com.example.tables.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.* ;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.Set;

@Entity
@Table(name = "course")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students;

}
