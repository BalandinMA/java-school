package java8_examples.multiple_inharitance;

/**
 * @author Evgeny Borisov
 */
public class Daughter implements Father,Mother {

    @Override
    public void speak() {
        Mother.super.speak();
        Father.super.speak();
    }
}
