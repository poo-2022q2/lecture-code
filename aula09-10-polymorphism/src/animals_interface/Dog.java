package animals_interface;

public class Dog implements Animal {
    @Override
    public String makeNoise() {
        return "auau";
    }

    @Override
    public String eatsWhat() {
        return "meat";
    }
}
