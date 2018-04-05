package service;

import repository.TablesRepository;

import javax.swing.table.TableModel;

public class TableService {

    public static TableModel readTableStudents() {
        return TablesRepository.getTableStudents();
    }

    public static TableModel readTableTeachers() {
        return TablesRepository.getTableTeachers();
    }

    public static TableModel readTableEnrollments() {
        return TablesRepository.getTableEnrollments();
    }

    public static TableModel readTableExams() {
        return TablesRepository.getTableExams();
    }

    public static TableModel readTableCourses() {
        return TablesRepository.getTableCourses();
    }

    public static TableModel readTableActivity(String s1, String s2) {
        return TablesRepository.getTablesActivity(s1, s2);
    }

    public static TableModel readTableActivity() {
        return TablesRepository.getTablesActivity();
    }
}
