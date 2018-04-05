package model;

public class Exam {
    int examId;
    int grade;

    public Exam(int examId, int grade) {
        this.examId = examId;
        this.grade = grade;
    }

    public Exam() {
        this.examId = 0;
        this.grade = 0;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
