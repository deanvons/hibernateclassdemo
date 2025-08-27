package no.loop.hibernation.demo.runners;

import no.loop.hibernation.demo.Models.Professor;
import no.loop.hibernation.demo.Models.Student;
import no.loop.hibernation.demo.Repositories.ProfessorRepository;
import no.loop.hibernation.demo.Repositories.StudentRepository;
import no.loop.hibernation.demo.Services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostGradManagerRunner implements CommandLineRunner {

    // dependency injection
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final StudentService studentService;

    public PostGradManagerRunner(StudentRepository studentRepository, ProfessorRepository professorRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------RUNNING-----------");


        System.out.println("------------👨‍🏭-----------");
        // need to interact with the data i.e. CRUD

        // CREATE
        var newStudent = new Student();
        newStudent.setName("Dean");
        studentService.registerStudent(newStudent);

//        //READ
        var checkStudent = studentService.lookupStudentById(1);
        System.out.println(checkStudent.getName());
//
//        System.out.println(pulledStudent.getName() + " was found");
//
//        //UPDATE
//        pulledStudent.setName("Dr Dean");
//        studentRepository.save(pulledStudent);
//
//        Student pulledStudentAfterUpdate = studentRepository.findById(pulledStudent.getId())
//                .orElseThrow(() -> {
//                    throw new IllegalArgumentException("Error");
//                });
//
//        System.out.println(pulledStudentAfterUpdate.getName() + " was found");
//
//        Professor newProf = new Professor();
//        newProf.setName("Prof Johan");
//        professorRepository.save(newProf);
//
//
//        pulledStudent.setProfessor(newProf);
//        anotherNewStudent.setProfessor(newProf);
//        studentRepository.save(pulledStudent);
//        studentRepository.save(anotherNewStudent);
//
//        //
//        Professor pulledProfessor = professorRepository.findById(newProf.getId())
//                .orElseThrow(() -> {
//                    throw new IllegalArgumentException("Error");
//                });
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
        //System.out.println(pulledProfessor.getStudents().toString());
        System.out.println("------------END-----------");
    }
}
