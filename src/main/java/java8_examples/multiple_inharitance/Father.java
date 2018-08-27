package java8_examples.multiple_inharitance;

/**
 * @author Evgeny Borisov
 */
public interface Father {
    default void speak(){
        System.out.println("Иди сюда, сынок");
    }

}
