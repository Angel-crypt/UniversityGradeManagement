import domain.Person;
import domain.SchoolSystem;

public class Main {
    public static void main(String[] args) {
        SchoolSystem school = new SchoolSystem();

        String degree = "Septimo";
        String department = "Tecnología";

        school.addStudent("Angel", "GU23IA0001", degree);
        school.addStudent("Mauricio", "GU23IA0008", degree);
        school.addStudent("Alfonso", "GU23IA0009", degree);

        school.addTeacher("Jonathan", "DO241", department);
        school.addTeacher("Abel", "D0242", department);

        school.addCourse("Programación Web", "DO241");
        school.addCourse("Base de Datos", "D0242");

        school.enrollStudent("GU23IA0001","PR1");

        school.displayAll();
    }
}