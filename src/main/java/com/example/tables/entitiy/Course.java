package com.example.tables.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.* ;
//import org.antlr.v4.runtime.misc.NotNull;


import java.util.Set;

@Entity
@Table(name = "course")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Student> students;

}
