package service;

import repository.ExamRepository;
import model.Exam;

public class ExamService {

    public static void addExam(int examId, int grade) {

        Exam exam = new Exam(examId, grade);

        assert (exam != new Exam());

        ExamRepository.addExam(exam);
    }

    public static void removeExam(int examId) {

        ExamRepository.deleteExam(examId);
    }

    public static void updateExam(int examId, int grade) {

        Exam exam = new Exam(examId, grade);

        assert (exam != new Exam());

        ExamRepository.updateExam(exam);
    }
}
