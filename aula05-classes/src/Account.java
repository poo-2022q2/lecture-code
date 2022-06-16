public class Account {

     private String number; // instance variable
    // public String number;
    private float balance;

    // default constructor
    public Account() {
        this.number = "0";
        this.balance = 0;
    }

    // overloaded constructor
    public Account(String number) {
        setNumber(number);
        this.balance = 0;
    }

    // overloaded constructor
    public Account(String number, float balance) {
        setNumber(number);
        setBalance(balance);
    }

    /**
     * Getter
     * @return the account number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter.
     * Account nummbers have two parts separated by hiphen.
     * The first part is at least one digit, the last part is
     * a digit, a x or X.
     * e.g. 12345-x , 12345-0
     * @param number the account number
     */
    public void setNumber(
            String number // parameter variable
    ) {
        String pattern = "\\d+-(\\d|x|X)"; // local variable

        if (number.matches(pattern)) {
            this.number = number;         // unshadow instance variable
        } else {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * Deposit an amount in the account
     * @param amount the amount to deposit
     */
    public void deposit(float amount) {
        if (amount < 0)
            throw new IllegalArgumentException("amount must not be negative");
        this.balance += amount;
    }

    /**
     * Withdraw an amount from the account, if there is enough balance
     * @param amount the amount to wihdraw
     * @return the updated balance
     */
    public double withdraw(float amount) {
        if (amount < 0)
            throw new IllegalArgumentException("amount must not be negative");
        if (balance < amount) {
            System.err.println("Insuficient funds");

            return this.balance;
        }

        this.balance -= amount;

        return this.balance;
    }

    /**
     * Builds a summary report of the account
     * @return the report as a string
     */
    public String buildReport() {
        return String.format("Account number: %s \n Balance: %.2f \n", this.number, this.balance);
    }


    public String toString() {
        return buildReport();
    }
}
