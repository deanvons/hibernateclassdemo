package no.loop.hibernation.demo.runners;

import no.loop.hibernation.demo.Models.Student;
import no.loop.hibernation.demo.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostGradManagerRunner implements CommandLineRunner {

    // inject student repository
    private final StudentRepository studentRepository;

    public PostGradManagerRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        Student pulledStudent = studentRepository.findById(1).get();
        System.out.println(pulledStudent.getName());

        // UPDATE
        pulledStudent.setName("Dr Dean");
        studentRepository.save(pulledStudent);

        // Check if updated correctly
        System.out.println(pulledStudent.getName());

        // DELETE


        studentRepository.delete(pulledStudent);

        System.out.println(pulledStudent.getName()); // note the student is still in memory here

        // Student pulledStudentTest = studentRepository.findById(1).get(); // fails need to check if it exists -> Optional. get()' without 'isPresent()' check


        if (!studentRepository.existsById(pulledStudent.getId())) {
            studentRepository.delete(pulledStudent);
            System.out.println("deleted");
        } else {
            System.out.println("not found");
        }


    }
}
