package animals_interface;

public class Cat implements Animal {
    @Override
    public String makeNoise() {
        return "miau";
    }

    @Override
    public String eatsWhat() {
        return "meat";
    }
}
