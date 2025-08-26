package no.loop.hibernation.demo.Repositories;

import no.loop.hibernation.demo.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
