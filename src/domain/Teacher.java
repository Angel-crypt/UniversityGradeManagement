package domain;

public class Teacher extends Person{
    private String department;

    public Teacher(String name, String id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public void displayInfo() {
        String info = String.format("%s (Departamento: %s)", toString(), department);
        System.out.println(info);
    }

    @Override
    public String getPersonType() {
        return "Profesor";
    }
}
