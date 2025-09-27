package domain;

public class Course {
    private static int countCourses = 0;
    private final String id;
    private String name;
    private final Teacher teacher;

    public Course(String name, Teacher teacher) {
        countCourses++;
        this.id = name.substring(0, Math.min(2, name.length())).toUpperCase() + countCourses;
        this.name = name;
        this.teacher = teacher;
    }

    public String getId() { return id; }
    public Teacher getTeacher() { return teacher; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return String.format("Curso: %s (ID: %s) impartido por el docente %s.",
                name, id, teacher.getName());
    }

    public void displayInfo() {
        System.out.println(toString());
    }
}
