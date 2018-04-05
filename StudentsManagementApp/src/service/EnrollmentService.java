package service;

import repository.EnrollmentRepository;
import model.Enrollment;

public class EnrollmentService {

    public static void addEnrollment(String enrollmentId, int studentId, int courseId, int examId) {

        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, examId);

        assert (enrollment != new Enrollment());

        EnrollmentRepository.addEnrollment(enrollment);
    }

    public static void removeEnrollment(String enrollmentId) {

        EnrollmentRepository.deleteEnrollment(enrollmentId);
    }

    public static void updateEnrollment(String enrollmentId, int studentId, int courseId, int examId) {

        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, examId);

        assert (enrollment != new Enrollment());

        EnrollmentRepository.updateEnrollment(enrollment);
    }
}
