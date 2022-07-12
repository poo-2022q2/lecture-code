package animals_interface;

public class AnimalTest {
    public static void reportAnimal(Animal animal) {
        System.out.println("Name: " + animal.getClass().getName());
        System.out.println("Eats: " + animal.eatsWhat());
        System.out.println("Noise: " + animal.makeNoise());
        System.out.println();
    }

    public static void main(String[] args) {
        reportAnimal(new Bird());
        reportAnimal(new Cat());
        reportAnimal(new Dog());
        reportAnimal(new Pig());
    }
}
