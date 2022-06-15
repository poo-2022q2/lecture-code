public class CheckPalindrome {
    static boolean isPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: ChecaPalindromo <word>");
        }

        if (isPalindrome(args[0]))
            System.out.println("Is palindrome");
        else
            System.out.println("Not palindrome");
    }
}
