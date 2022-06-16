public class StringReferences {
    public static void main(String[] args) {
        // shallow equality vs. deep equality
        String s1 = new String("String A");
        String s2 = new String("String A");

        // shallow equality
        System.out.println(s1 == s2);
        // deep equality
        System.out.println(s1.equals(s2));

        System.out.println();

        // interning
        String s3 = "String B";
        String s4 = "String B";

        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
    }
}
