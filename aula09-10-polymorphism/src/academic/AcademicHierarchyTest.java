package academic;

public class AcademicHierarchyTest {

    public static String showAffiliation(AcademicMember m) {
        if (m instanceof Professor) {
           return  ((Professor) m).getDepartment();
        } else if (m instanceof Student) {
            return ((Student) m).getCourse();
        } else {
            return "Unknown affiliation";
        }
    }

    public static void main(String[] args) {
        AcademicMember a1;

        a1 = new Student("joao", "cardoso", "123", "bcc", 18);

        System.out.println(a1);

        System.out.println(showAffiliation(a1));

        a1 = new Professor("cassio", "amadeu", "324", "cmcc");

        System.out.println(a1.toString());

        System.out.println(showAffiliation(a1));

    }
}
