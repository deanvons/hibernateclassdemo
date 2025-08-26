package no.loop.hibernation.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    // this student model will reference a professor
    // the student is the owner of this relationships

    @ManyToOne(optional = true)
    private Professor professor;




}
