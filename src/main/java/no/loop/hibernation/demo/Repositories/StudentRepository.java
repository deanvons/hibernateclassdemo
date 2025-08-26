package no.loop.hibernation.demo.Repositories;

import no.loop.hibernation.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // find students without a professor
    // filter students by professor id
    // find by name containing

}
