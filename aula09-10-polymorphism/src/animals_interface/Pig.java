package animals_interface;

public class Pig implements Animal {
    @Override
    public String makeNoise() {
        return "oinc oinc";
    }

    @Override
    public String eatsWhat() {
        return "anything";
    }
}
