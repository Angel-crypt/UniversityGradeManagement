package domain;

import java.util.List;

public class DisplayManager {
    public void displayAllStudents(List<Student> studentList) {
        if (!studentList.isEmpty()) {
            System.out.println("\n=== ESTUDIANTES ===");
            for (Student student : studentList) {
                student.displayInfo(); // Aprovecha polimorfismo
            }
        } else {
            System.out.println("No hay estudiantes registrados.");
        }
    }

    public void displayAllTeachers(List<Teacher> teacherList) {
        if (!teacherList.isEmpty()) {
            System.out.println("\n=== PROFESORES ===");
            for (Teacher teacher : teacherList) {
                teacher.displayInfo(); // Aprovecha polimorfismo
            }
        } else {
            System.out.println("No hay profesores registrados.");
        }
    }

    public void displayAllCourses(List<Course> coursesList) {
        if (!coursesList.isEmpty()) {
            System.out.println("\n=== CURSOS ===");
            for (Course course : coursesList) {
                course.displayInfo();
            }
        } else {
            System.out.println("No hay cursos registrados.");
        }
    }

    public void displayAllEnrollments(List<Enrollment> enrollmentList) {
        if (!enrollmentList.isEmpty()) {
            System.out.println("\n=== INSCRIPCIONES ===");
            for (Enrollment enrollment : enrollmentList) {
                enrollment.displayInfo();
            }
        } else {
            System.out.println("No hay inscripciones registradas.");
        }
    }

    public void displayStudentAverage(float average){
        System.out.println("El promedio del alumno es: " + average);
    }

    public void displaySystemSummary(List<Student> students, List<Teacher> teachers,
                                     List<Course> courses, List<Enrollment> enrollments) {
        System.out.println(Constants.SYSTEM_NAME);
        displayAllStudents(students);
        displayAllTeachers(teachers);
        displayAllCourses(courses);
        displayAllEnrollments(enrollments);
    }
}
