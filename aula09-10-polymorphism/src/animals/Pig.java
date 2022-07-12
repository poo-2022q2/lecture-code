package animals;

public class Pig extends Animal {
    @Override
    protected String makeNoise() {
        return "oinc oinc";
    }

    @Override
    protected String eatsWhat() {
        return "anything";
    }
}
