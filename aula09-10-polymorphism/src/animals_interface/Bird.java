package animals_interface;

public class Bird implements Animal {
    @Override
    public String makeNoise() {
        return "piupiu";
    }

    @Override
    public String eatsWhat() {
        return "seeds";
    }
}
