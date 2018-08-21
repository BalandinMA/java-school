package overloading;

/**
 * @author Evgeny Borisov
 */
public class NumberUtil {
    public static void doX(long l) {
        System.out.println("long "+l );
    }

    public static void doX(Integer i) {
        System.out.println("integer "+i);
    }

    public static void main(String[] args) {
        doX(12);
    }
}
