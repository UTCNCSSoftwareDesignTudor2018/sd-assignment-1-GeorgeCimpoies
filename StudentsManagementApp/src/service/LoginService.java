package service;

import repository.StudentRepository;
import repository.TeacherRepository;

public class LoginService {

    public static int checkLogin(String username, String password) {

        if (StudentRepository.readStudentFromUsername(username) != null && password.equals(StudentRepository.readStudentFromUsername(username).getPassword())) {
            return 0;
        } else if (TeacherRepository.readTeacherFromUsername(username) != null && password.equals(TeacherRepository.readTeacherFromUsername(username).getPassword())) {
            return 1;
        } else return -1;
    }
}
