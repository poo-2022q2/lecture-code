public class Strings {

    public static void main(String[] args) {
        // concatenation
        String s1 = "hello";
        String s2 = "world";

        String s3 = s1 + " " + s2;

        System.out.println(s3);
        System.out.println();

        // implicit number conversion
        System.out.println("bloco" + 1);
        System.out.println("versao " + 2.5);
        System.out.println();

        // conversion to other types
        String si = "10";
        String sd = "22.34";

        System.out.println(si + 1);
        System.out.println(sd + 0.1);

        int i = Integer.parseInt(si);
        double d = Double.parseDouble(sd);
        System.out.println(i + 1);
        System.out.println(d + 0.1);
    }
}
