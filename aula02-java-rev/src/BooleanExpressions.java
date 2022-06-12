public class BooleanExpressions {
    public static void main(String[] args) {
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(true && false);
        System.out.println(true && true);
        System.out.println();

        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || false);
        System.out.println(true || true);
        System.out.println();

        System.out.println(false ^ false);
        System.out.println(false ^ true);
        System.out.println(true ^ false);
        System.out.println(true ^ true);
        System.out.println();

        System.out.println(!false);
        System.out.println(!true);

        System.out.println();

        System.out.println(true || false && true || !false);
    }
}
