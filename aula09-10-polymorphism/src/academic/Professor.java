package academic;

public class Professor extends AcademicMember {
    String siape;
    String department;

    public Professor(String firstName, String lastName, String siape, String department) {
        super(firstName, lastName);
        setSiape(siape);
        setDepartment(department);
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "Siape: " + this.siape + "\n"
                + "Department: " + this.department + "\n";
    }
}
