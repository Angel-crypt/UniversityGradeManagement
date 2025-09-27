package domain;

import java.util.ArrayList;
import java.util.List;

public class SchoolSystem {
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> coursesList = new ArrayList<>();
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public Teacher findTeacherById(String id) {
        for (Teacher t : teacherList) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(String id) {
        for (Course c : coursesList) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void addStudent(String name, String id, String degree) {
        Student student = new Student(name, id, degree);
        studentList.add(student);
        System.out.println("Estudiante " + name + " agregado al sistema.");
    }

    public void addTeacher(String name, String id, String department) {
        Teacher teacher = new Teacher(name, id, department);
        teacherList.add(teacher);
        System.out.println("Profesor " + name + " agregado al sistema.");
    }

    public void addCourse(String name, String teacherId){
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("El profesor no está registrado en el sistema.");
            return;
        }
        Course course = new Course(name, teacher);
        if (coursesList.contains(course)){
            System.out.println("El curso ya existe.");
            return;
        }
        coursesList.add(course);
        System.out.println("Curso " + name + " impartido por el docente " + teacher.getName() + " agregado correctamente.");
    }

    public void enrollStudent(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
        if (course == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        if (student.getEnrolledCoursesCount() >= Constants.MAX_SUBJECTS_PER_STUDENT) {
            System.out.println("Máximo de materias alcanzado");
            return;
        }

        Enrollment enrollment = new Enrollment(student, course);
        enrollmentList.add(enrollment);
        student.incrementEnrollments();
        System.out.println("Alumno " + student.getName() + " inscrito correctamente al curso " + course.getName());
    }

    public void displayAllStudents() {
        if (!studentList.isEmpty()){
            System.out.println("\n=== ESTUDIANTES ===");
            for (Student s : studentList){
                s.displayInfo();
            }
        } else {
            System.out.println("No hay estudiantes registrados.");
        }
    }
    public void displayAllTeachers() {
        if (!teacherList.isEmpty()){
            System.out.println("\n=== PROFESORES ===");
            for (Teacher t : teacherList){
                t.displayInfo();
            }
        } else {
            System.out.println("No hay profesores registrados.");
        }
    }

    public void displayAllCourses() {
        if (!coursesList.isEmpty()){
            System.out.println("\n=== Cursos ===");
            for (Course c : coursesList){
                c.displayInfo();
            }
        } else {
            System.out.println("No hay cursos registrados.");
        }
    }

    public void displayAllEnrollments() {
        if (!enrollmentList.isEmpty()){
            System.out.println("\n=== Inscripciones ===");
            for (Enrollment e : enrollmentList){
                e.displayInfo();
            }
        } else {
            System.out.println("No hay cursos registrados.");
        }
    }

    public void displayAll() {
        displayAllStudents();
        displayAllTeachers();
        displayAllCourses();
        displayAllEnrollments();
    }
}
