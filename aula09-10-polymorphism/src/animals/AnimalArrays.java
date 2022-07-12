package animals;

public class AnimalArrays {

    public static void main(String[] args) {
        Dog[] dogs = new Dog[] {
                new Dog(),
                new Dog()
        };

        Animal[] animals = new Animal[] {
                new Dog(),
                new Cat(),
                new Dog(),
                new Pig(),
                new Bird()
        };

        Object[] objects = new Object[] {
                "hello",
                10,
                10.0,
                true
        };
    }
}
