package repository;

import model.Exam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExamRepository {

    public static void addExam(Exam exam) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO exams (idexam,grade) VALUES(?,?)");
            posted.setInt(1, exam.getExamId());
            posted.setInt(2, exam.getGrade());
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Complete");
        }
    }

    public static void deleteExam(int examId) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("DELETE FROM exams where idexam=?");
            posted.setInt(1, examId);

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Delete Complete");
        }
    }

    public static void updateExam(Exam exam) {

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("Update exams set idexam=?,grade=? where idexam=?");
            posted.setInt(1, exam.getExamId());
            posted.setInt(2, exam.getGrade());
            posted.setInt(3, exam.getExamId());

            posted.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Update Complete");
        }
    }

    static Exam readExam(int examId) {

        Exam exam = new Exam();

        try {
            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement posted = con.prepareStatement("select idexam,grade from exams where idexam=?");
            posted.setInt(1, examId);

            ResultSet m = posted.executeQuery();

            while (m.next()) {

                exam.setExamId(m.getInt(1));
                exam.setGrade(m.getInt(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Read Complete");
        }
        return exam;
    }
}
