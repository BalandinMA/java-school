package polimorphism;

/**
 * @author Evgeny Borisov
 */
public class Bee implements Animal {
    @Override
    public void makeVoice() {
        System.out.println("tr tr");
    }
}
