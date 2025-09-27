package domain;

public class Enrollment {
    private final Student student;
    private final Course course;
    private float grade;

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }

    public float getGrade() { return grade; }
    public void setGrade(float grade) { this.grade = grade; }

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Inscripcion: %s (ID estudiante: %s) (Curso: %s) (ID maestro: %s) (Calificación: %.1f)",
                student.getName(), student.getId(), course.getName(), course.getTeacher().getId(), grade);
    }

    public void displayInfo() {
        System.out.println(toString());
    }
}
