package polimorphism;

/**
 * @author Evgeny Borisov
 */
public class Dog implements Animal {
    @Override
    public void makeVoice() {
        System.out.println("au au");
    }

    public void принесиПалку() {
        System.out.println("уже несу");
    }


}
