package my_spring;

import java.util.Date;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    public CleanerImpl() {
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVVVVvvvvvvvvvvvvvvvvvv");
        }
    }
}
