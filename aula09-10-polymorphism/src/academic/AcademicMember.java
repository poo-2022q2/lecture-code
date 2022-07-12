package academic;

public abstract class AcademicMember {
    private String firstName;
    private String lastName;

    public AcademicMember(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Nome: " + this.firstName + " " + this.lastName + "\n";
    }
}
