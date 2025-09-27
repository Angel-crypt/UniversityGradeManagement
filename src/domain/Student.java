package domain;

public class Student extends Person {
    private String degree;
    private int enrolledCoursesCount = 0;

    public Student(String name, String id, String degree) {
        super(name, id);
        this.degree = degree;
    }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    @Override
    public String getPersonType() { return "Estudiante"; }

    @Override
    public void displayInfo() {
        String info = String.format("%s (Grado: %s)", toString(), degree);
        System.out.println(info);
    }

    public int getEnrolledCoursesCount() { return enrolledCoursesCount; }
    void incrementEnrollments() { enrolledCoursesCount++; }
    void decrementEnrollments() {
        if (enrolledCoursesCount > 0) enrolledCoursesCount--;
    }
}
