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

        // need to interact with the data

        // register some student
        Student newStudent = new Student();
        newStudent.setName("Dean");

        studentRepository.save(newStudent);

//        how ?
//        we need a repository look up top, DI

    }
}
