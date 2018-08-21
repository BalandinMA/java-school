package autoboxing;

import polimorphism.Dog;

import java.util.ArrayList;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Dog());
        objects.add(Integer.valueOf(12));

        System.out.println(objects);
    }
}
