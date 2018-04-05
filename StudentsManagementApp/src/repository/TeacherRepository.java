package repository;

import model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherRepository {

    public static void addTeacher(Teacher teacher) {
        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO teachers (idteacher,name,username,password) VALUES(?,?,?,?)");
            posted.setInt(1, teacher.getTeacherId());
            posted.setString(2, teacher.getName());
            posted.setString(3, teacher.getUsername());
            posted.setString(4, teacher.getPassword());

            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Complete");
        }
    }

    public static void deleteTeacher(String username) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM teachers where username=?");
            posted.setString(1, username);

            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Delete Complete");
        }
    }

    public static void updateTeacher(Teacher teacher) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update teachers set `name`=?,password=? where `username`=?");
            posted.setString(1, teacher.getName());
            posted.setString(2, teacher.getPassword());
            posted.setString(3, teacher.getUsername());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }
    }

    public static Teacher readTeacherFromName(String name) {

        Teacher teacher = new Teacher();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("select `name`,username,password from teachers where `name`=?");
            posted.setString(1, name);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                teacher.setName(m.getString(1));
                teacher.setUsername(m.getString(2));
                teacher.setPassword(m.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return teacher;
    }

    public static Teacher readTeacherFromUsername(String username) {

        Teacher teacher = new Teacher();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("select `name`,username,password from teachers where username=?");
            posted.setString(1, username);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                teacher.setName(m.getString(1));
                teacher.setUsername(m.getString(2));
                teacher.setPassword(m.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return teacher;
    }
}
