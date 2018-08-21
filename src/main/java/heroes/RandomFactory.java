package heroes;

import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author Evgeny Borisov
 */
public class RandomFactory {

    private static DataFactory dataFactory = new DataFactory();
    private static RandomFactory ourInstance = new RandomFactory();

    public static RandomFactory getInstance() {
        return ourInstance;
    }

    private RandomFactory() {
    }

    public int getNumberBetween(int min, int max) {
       return dataFactory.getNumberBetween(min, max);
    }
}
