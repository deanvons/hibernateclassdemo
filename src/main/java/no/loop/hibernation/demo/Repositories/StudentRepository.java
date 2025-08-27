package no.loop.hibernation.demo.Repositories;

import no.loop.hibernation.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // find students without a professor
    List<Student> findByProfessorIsNull();
    // filter students with a prof
    List<Student> findByProfessorIsNotNull();
    // find by name containing

}
