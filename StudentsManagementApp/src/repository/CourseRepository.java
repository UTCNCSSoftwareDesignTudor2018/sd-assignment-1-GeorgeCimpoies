package repository;

import model.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseRepository {

    public static void addCourse(Course course) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO courses (idcourse,`name`,teachers_id) VALUES(?,?,?)");
            posted.setInt(1, course.getCourseId());
            posted.setString(2, course.getName());
            posted.setInt(3, course.getTeacherId());
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Complete");
        }
    }

    public static void deleteCourse(int courseId) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM courses where idcourse=?");
            posted.setInt(1, courseId);

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Delete Complete");
        }
    }

    public static void updateCourse(Course course) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update courses set idcourse=?,`name`=?,teachers_id=? where idcourse=?");
            posted.setInt(1, course.getCourseId());
            posted.setString(2, course.getName());
            posted.setInt(3, course.getTeacherId());
            posted.setInt(4, course.getCourseId());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }
    }

    static Course readCourse(int courseId) {

        Course course = new Course();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("SELECT idcourse,`name`,teachers_id from courses where idcourse=?");
            posted.setInt(1, courseId);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                course.setCourseId(m.getInt(1));
                course.setName(m.getString(2));
                course.setTeacherId(m.getInt(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return course;
    }

}
