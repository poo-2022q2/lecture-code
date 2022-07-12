package animals;

public class Cat extends Animal {
    @Override
    protected String makeNoise() {
        return "miau";
    }

    @Override
    protected String eatsWhat() {
        return "meat";
    }
}
