package model;

public class Course {

    int courseId;
    String name;
    int teacherId;

    public Course(int courseId, String name, int teacherId) {
        this.courseId = courseId;
        this.name = name;
        this.teacherId = teacherId;
    }

    public Course(){
        this.courseId = 0;
        this.name = "";
        this.teacherId = 0;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
