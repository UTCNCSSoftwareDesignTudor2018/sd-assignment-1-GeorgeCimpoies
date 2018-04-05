package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import model.Student;

public class StudentRepository {


    public static void addStudent(Student student) {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO students (idstudent,`name`,card_nr,personal_numerical_code,address,`group`,username,password) VALUES(?,?,?,?,?,?,?,?)");
            posted.setInt(1, student.getStudentId());
            posted.setString(2, student.getName());
            posted.setString(3, student.getCardNo());
            posted.setString(4, student.getPersonalNumericalCode());
            posted.setString(5, student.getAddress());
            posted.setString(6, student.getGroup());
            posted.setString(7, student.getUsername());
            posted.setString(8, student.getPassword());

            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Complete");
        }
    }

    public static void deleteStudent(int personalNumericalCode) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM students where personal_numerical_code=?");
            posted.setInt(1, personalNumericalCode);

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Delete Complete");
        }
    }

    public static void updateStudent(Student student) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update students set `name`=?,card_nr=?,address=?,`group`=?,username=?,password=? where personal_numerical_code=?");
            posted.setString(1, student.getName());
            posted.setString(2, student.getCardNo());
            posted.setString(3, student.getAddress());
            posted.setString(4, student.getGroup());
            posted.setString(5, student.getUsername());
            posted.setString(6, student.getPassword());
            posted.setString(7, student.getPersonalNumericalCode());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }

    }

    public static Optional<Student> readStudentFromPNC(String personalNumericalCode) {

        Student student = new Student();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("SELECT name,card_nr,personal_numerical_code,address,group,username,password from students where personal_numerical_code=?");
            posted.setString(1, personalNumericalCode);

            ResultSet m = posted.executeQuery();

            getStudentObject(personalNumericalCode, student, m);

        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        } finally {
            System.out.println("Read Complete");
        }
        return Optional.of(student);
    }

    public static Student readStudentFromUsername(String username) {

        Student student = new Student();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("SELECT `name`,card_nr,personal_numerical_code,address,`group`,username,password from students where username=?");
            posted.setString(1, username);

            ResultSet m = posted.executeQuery();

            getStudentObject(username, student, m);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return student;
    }

    private static void getStudentObject(String username, Student student, ResultSet m) throws SQLException {
        while (m.next()) {

            student.setName(m.getString(1));
            student.setCardNo(m.getString(2));
            student.setPersonalNumericalCode(m.getString(3));
            student.setAddress(m.getString(4));
            student.setGroup(m.getString(5));
            student.setUsername(m.getString(6));
            student.setPassword(m.getString(7));
            student.setPersonalNumericalCode(username);
        }
    }
}

