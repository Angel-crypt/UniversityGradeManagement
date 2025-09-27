package domain;

import java.util.ArrayList;
import java.util.List;

public class SchoolSystem {
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> coursesList = new ArrayList<>();
    private List<Enrollment> enrollmentList = new ArrayList<>();
    private final DisplayManager displayManager;

    public SchoolSystem() {
        this.displayManager = new DisplayManager();
    }

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

    public Enrollment findEnrollment(String studentId, String courseId){
        for (Enrollment e : enrollmentList){
            if (e.getStudent().getId().equals(studentId) && e.getCourse().getId().equals(courseId)){
                return e;
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
            System.out.println("Estudiante con ID " + studentId + " no encontrado.");
            return;
        }
        if (course == null) {
            System.out.println("Curso con ID " + courseId + " no encontrado.");
            return;
        }

        if (student.getEnrolledCoursesCount() >= Constants.MAX_SUBJECTS_PER_STUDENT) {
            System.out.println("El estudiante " + student.getName() +
                    " ya alcanzó el máximo de materias (" +
                    Constants.MAX_SUBJECTS_PER_STUDENT + ")");
            return;
        }

        Enrollment enrollment = new Enrollment(student, course);
        enrollmentList.add(enrollment);
        student.incrementEnrollments();
        System.out.println("Alumno " + student.getName() + " inscrito correctamente al curso " + course.getName());
    }

    public void registerGrade(String studentId, String courseId, float grade) {
        if (grade < 0 || grade > 10) {
            System.out.println("La calificación debe estar entre 0 y 10.");
            return;
        }

        Enrollment enrollment = findEnrollment(studentId, courseId);
        if (enrollment == null) {
            System.out.println("No se encontró la inscripción del estudiante en este curso.");
            return;
        }

        enrollment.setGrade(grade);
        System.out.println("Calificación " + grade + " registrada para " +
                enrollment.getStudent().getName() +
                " en el curso " + enrollment.getCourse().getName());
    }

    public float calculateStudentAverage(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Estudiante no encontrado.");
            return -1;
        }

        List<Enrollment> studentEnrollments = getStudentEnrollments(studentId);
        if (studentEnrollments.isEmpty()) {
            System.out.println("El estudiante no tiene inscripciones con calificaciones.");
            return 0;
        }

        float sum = 0;
        int count = 0;
        for (Enrollment e : studentEnrollments) {
            sum += e.getGrade();
            count ++;
        }

        return count > 0 ? sum / count : 0;
    }

    private List<Enrollment> getStudentEnrollments(String studentId) {
        List<Enrollment> enrollments = new ArrayList<>();
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().getId().equals(studentId)){
                enrollments.add(e);
            }
        }
        return enrollments;
    }

    public void displayAllStudents() {
        displayManager.displayAllStudents(studentList);
    }

    public void displayAllTeachers() {
        displayManager.displayAllTeachers(teacherList);
    }

    public void displayAllCourses() {
        displayManager.displayAllCourses(coursesList);
    }

    public void displayAllEnrollments() {
        displayManager.displayAllEnrollments(enrollmentList);
    }

    public void displayAll() {
        displayManager.displaySystemSummary(studentList, teacherList, coursesList, enrollmentList);
    }
    public void displayStudentAverage(float average) {
        displayManager.displayStudentAverage(average);
    }
}
