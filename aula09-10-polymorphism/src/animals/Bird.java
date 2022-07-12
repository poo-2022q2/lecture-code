package animals;

public class Bird extends Animal {
    @Override
    protected String makeNoise() {
        return "piupiu";
    }

    @Override
    protected String eatsWhat() {
        return "seeds";
    }
}
