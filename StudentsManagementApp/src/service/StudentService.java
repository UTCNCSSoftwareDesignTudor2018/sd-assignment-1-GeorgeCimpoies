package service;

import repository.StudentRepository;
import model.Student;

public class StudentService {

    public static void addStudent(String name, String cardNo, String personalNumericalCode, String address, String group, String username, String password) {

        Student student = new Student(name, cardNo, personalNumericalCode, address, group, username, password);

        assert (student != new Student());

        StudentRepository.addStudent(student);
    }

    public static void removeStudent(int personalNumericCode) {

        StudentRepository.deleteStudent(personalNumericCode);

    }

    public static void updateStudent(String name, String cardNo, String personalNumericalCode, String address, String group, String username, String password) {


        Student student = new Student(name, cardNo, personalNumericalCode, address, group, username, password);

        assert (student != new Student());

        StudentRepository.updateStudent(student);

    }
}
