package service;

import repository.CourseRepository;
import model.Course;

public class CourseService {

    public static void addCourse(String name, int courseId, int teacherId) {

        Course course = new Course(courseId, name, teacherId);

        assert (course != new Course());

        CourseRepository.addCourse(course);
    }

    public static void removeCourse(int courseId) {

        CourseRepository.deleteCourse(courseId);
    }

    public static void updateCourse(String name, int courseId, int teacherId) {

        Course course = new Course(courseId, name, teacherId);

        assert (course != new Course());

        CourseRepository.updateCourse(course);
    }

}
