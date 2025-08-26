package no.loop.hibernation.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Student> students;


}
