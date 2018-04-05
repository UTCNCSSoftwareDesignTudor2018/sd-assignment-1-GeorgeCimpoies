package repository;

import model.Enrollment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnrollmentRepository {

    public static void addEnrollment(Enrollment enrollment) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO enrollments (idenrollment,students_id,courses_id,exams_id) VALUES(?,?,?,?)");
            posted.setString(1, enrollment.getEnrollmentId());
            posted.setInt(2, enrollment.getStudentId());
            posted.setInt(3, enrollment.getCourseId());
            posted.setInt(4, enrollment.getExamId());
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Complete");
        }
    }

    public static void deleteEnrollment(String enrollmentId) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM enrollments where idenrollment=?");
            posted.setString(1, enrollmentId);

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Delete Complete");
        }
    }

    public static void updateEnrollment(Enrollment enrollment) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update enrollments set idenrollment=?,students_id=?,courses_id=?,exams_id=? where idenrollment=?");
            posted.setString(1, enrollment.getEnrollmentId());
            posted.setInt(2, enrollment.getStudentId());
            posted.setInt(3, enrollment.getCourseId());
            posted.setInt(4, enrollment.getExamId());
            posted.setString(5, enrollment.getEnrollmentId());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }
    }

    static Enrollment readEnrollment(String enrollmentId) {

        Enrollment enrollment = new Enrollment();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("idenrollment,students_id,courses_id,exams_id from enrollments where idenrollment=?");
            posted.setString(1, enrollmentId);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                enrollment.setEnrollmentId(m.getString(1));
                enrollment.setStudentId(m.getInt(2));
                enrollment.setCourseId(m.getInt(3));
                enrollment.setExamId(m.getInt(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return enrollment;
    }
}
