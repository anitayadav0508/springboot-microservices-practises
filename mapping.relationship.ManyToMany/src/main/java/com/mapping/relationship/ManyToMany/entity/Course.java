package com.mapping.relationship.ManyToMany.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/*One course can purchase by multiple student and this is the child entity*/

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String abbreviation;
    private Integer modules;
    private Double fee;


    //mappedBy attribute indicate that entity who owns the bidirectional relationship, in bidirectional relationship we define the many to many relationship on both the entity but only one entity can own the relationship and we pick Student entity is owned entity that is why on course entity i define mapped by.

    /*I have to tell that JPA Student is  owner entity, and course is not a owner entity by using mappedBy attribute
    * */
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Student> students;


}
