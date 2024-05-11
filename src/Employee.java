import java.util.Objects;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastname;
    private int department;
    private double salary;
    private int id;
    private static Integer idCounter = 1;

    public Employee(String firstName, String middleName,
                    String lastName, int department, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastName;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddleName() {
        return middleName;
    }
    public String getFirstName() {
        return firstName;
    }

    public int hashCode() {
        return Objects.hash(firstName, middleName, lastname, department, salary);
    }

    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Employee employee = (Employee) a;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName) &&
                Objects.equals(lastname, employee.lastname) && department == employee.department
                && salary == employee.salary && id == employee.id;
    }
    public String toString() {
        return String.format("ИН: %s, ФИО: %s %s %s, отдел: %s, заработная плата: %.2f руб.",
                id, firstName, middleName, lastname, department, salary);
    }
    public String printPersonWithOutDepartment() {
        return String.format("ИН: %s, ФИО: %s %s %s, заработная плата: %.2f руб.",
                id, firstName, middleName, lastname, salary);
    }
}

