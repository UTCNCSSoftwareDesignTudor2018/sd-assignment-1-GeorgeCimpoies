package service;

import repository.TeacherRepository;
import model.Teacher;

public class TeacherService {

    public static void addTeacher(String name, String username, String password) {

        Teacher teacher = new Teacher(name, username, password);

        assert (teacher != new Teacher());

        TeacherRepository.addTeacher(teacher);
    }

    public static void removeTeacher(String username) {

        TeacherRepository.deleteTeacher(username);
    }

    public static void updateTeacher(String name, String username, String password) {

        Teacher teacher = new Teacher(name, username, password);

        assert (teacher != new Teacher());

        TeacherRepository.updateTeacher(teacher);
    }
}
