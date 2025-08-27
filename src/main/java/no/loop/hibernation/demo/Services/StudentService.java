package no.loop.hibernation.demo.Services;

import no.loop.hibernation.demo.Models.Student;
import no.loop.hibernation.demo.Repositories.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    public Student lookupStudentById(Integer id) throws IllegalArgumentException {
        Student registeredStudent = studentRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Error");
                });

        return registeredStudent;
    }





}
