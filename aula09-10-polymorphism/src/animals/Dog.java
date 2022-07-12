package animals;

public class Dog extends Animal{
    @Override
    protected String makeNoise() {
        return "auau";
    }

    @Override
    protected String eatsWhat() {
        return "meat";
    }
}
