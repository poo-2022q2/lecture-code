public class AccountTest {
    public static void main(String[] args) {
        Account acc1 = new Account("12345-X");
        Account acc2 = new Account("4321-X", 100);
        Account acc3 = new Account();

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);

        acc1.deposit(50);
        System.out.println(acc1);
        System.out.println(acc1.withdraw(30));
        System.out.println(acc1);
        System.out.println(acc1.withdraw(30));
        System.out.println(acc1);

//        acc2.deposit(-10);
        acc2.withdraw(-30);
    }
}
