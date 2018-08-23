package exercise_creator;

import java.util.Random;

public class RandomHolder {
    private static Random ourInstance = new Random();

    public static Random getInstance() {
        return ourInstance;
    }

}
