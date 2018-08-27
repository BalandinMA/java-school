package java8_examples.multiple_inharitance;

/**
 * @author Evgeny Borisov
 */
public interface Mother {
    default void speak(){
        System.out.println("ИДИ СЮДА, СЫНОК!!!!");
    }

}
