package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class TablesRepository {


    public static TableModel getTableStudents() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from students");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTableTeachers() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from teachers");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTablesActivity() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from activities");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTablesActivity(String s1, String s2) {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from activities where Date between ? and ?");
            statement.setString(1, s1);
            statement.setString(2, s2);

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTableEnrollments() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from enrollments");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTableExams() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from exams");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }

    public static TableModel getTableCourses() {

        try {

            java.sql.Connection con = ConnectionRepository.getConnection();
            PreparedStatement statement = con.prepareStatement("Select * from courses");

            ResultSet result = statement.executeQuery();
            return DbUtils.resultSetToTableModel(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("");
        }
        return null;
    }
}