package no.loop.hibernation.demo.runners;

import jakarta.transaction.Transactional;
import no.loop.hibernation.demo.Models.Professor;
import no.loop.hibernation.demo.Models.Student;
import no.loop.hibernation.demo.Repositories.ProfessorRepository;
import no.loop.hibernation.demo.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostGradManagerRunner implements CommandLineRunner {

    // dependency injection
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public PostGradManagerRunner(StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------RUNNING---------------------");
        // need to interact with the data i.e. CRUD
        // register some student
        // CREATE
        Student newStudent = new Student();
        newStudent.setName("Dean");
        studentRepository.save(newStudent);

        Student anotherNewStudent = new Student();
        anotherNewStudent.setName("Phteven");
        studentRepository.save(anotherNewStudent);

        //READ
        // there is a chance this student is not in the table
        Student pulledStudent = studentRepository.findById(newStudent.getId())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Error");
                });

        System.out.println(pulledStudent.getName() + " was found");

        //UPDATE
        pulledStudent.setName("Dr Dean");
        studentRepository.save(pulledStudent);

        Student pulledStudentAfterUpdate = studentRepository.findById(pulledStudent.getId())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Error");
                });

        System.out.println(pulledStudentAfterUpdate.getName() + " was found");

        Professor newProf = new Professor();
        newProf.setName("Prof Johan");
        professorRepository.save(newProf);


        pulledStudent.setProfessor(newProf);
        anotherNewStudent.setProfessor(newProf);
        studentRepository.save(pulledStudent);
        studentRepository.save(anotherNewStudent);

        //
        Professor pulledProfessor = professorRepository.findById(newProf.getId())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Error");
                });
//        try {
//            //DELETE
//            studentRepository.delete(pulledStudentAfterUpdate);
//            Student pulledStudentAttemptAfterDelete = studentRepository.findById(1)
//                    .orElseThrow(() -> {
//                        throw new IllegalArgumentException("Error");
//                    });
//        } catch (IllegalArgumentException e) {
//            System.out.println("not found");
//        }
        //System.out.println(pulledProfessor.getStudents().toString()); // lazy loading doesn't work outside a transaction

        var noprof = studentRepository.findByProfessorIsNull();
        var gotprof = studentRepository.findByProfessorIsNotNull();
        System.out.println("-------------------DONE---------------------");

    }


}
