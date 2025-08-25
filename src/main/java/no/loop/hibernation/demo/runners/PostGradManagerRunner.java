package no.loop.hibernation.demo.runners;

import no.loop.hibernation.demo.Models.Professor;
import no.loop.hibernation.demo.Models.Student;
import no.loop.hibernation.demo.Repositories.ProfessorRepository;
import no.loop.hibernation.demo.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostGradManagerRunner implements CommandLineRunner {

    // inject student repository
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public PostGradManagerRunner(StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running");

        // need to interact with the data - CRUD
        // register some student

        // CREATE
        Student newStudent = new Student();
        newStudent.setName("Dean");
        studentRepository.save(newStudent);

        //READ
        Student pulledStudent = studentRepository.findById(newStudent.getId()).orElseThrow(() -> new IllegalArgumentException("Student not found: " + newStudent.getId()));
        System.out.println(pulledStudent.getName());

        // UPDATE
        pulledStudent.setName("Dr Dean");
        studentRepository.save(pulledStudent);

        // Check if updated correctly
        System.out.println(pulledStudent.getName());

//        // DELETE
//        studentRepository.delete(pulledStudent);
//        // studentRepository.flush(); // apparently forces DELETE
//        System.out.println(pulledStudent.getName()); // note the student is still in memory here
//
//        // Student pulledStudentTest = studentRepository.findById(1).get(); // fails need to check if it exists -> Optional. get()' without 'isPresent()' check
//        if (!studentRepository.existsById(pulledStudent.getId())) {
//            studentRepository.delete(pulledStudent);
//            System.out.println("deleted");
//        } else {
//            System.out.println("not found");
//        }

        Professor newprof = new Professor();
        newprof.setName("Prof Java");
        professorRepository.save(newprof);
        var pulledProf = professorRepository.findById(newprof.getId()).orElseThrow(() -> new IllegalArgumentException("Prof not found: " + newprof.getId()));

        // allocate student to the professor
        newStudent.setProfessor(pulledProf);
        studentRepository.save(newStudent);
    }
}
