package com.mapping.relationship.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/*One student can opt multiple course*/

/*Don't use @Data instead of this use
* @Setter , @Getter */

// Student table is the owner table.
@Entity
@Table(name="STUDENT_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",
            joinColumns = {
             @JoinColumn(name="student_id", referencedColumnName = "id")

            },
            inverseJoinColumns = {
               @JoinColumn(name = "course_id",referencedColumnName = "id")
            }
    )
    @JsonManagedReference

    private Set<Course> courses;


}
