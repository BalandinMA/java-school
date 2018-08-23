package tdd;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class NdsResolverSingleton {
    private static NdsResolverSingleton ourInstance = new NdsResolverSingleton();
    private final double nds;

    public static NdsResolverSingleton getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private NdsResolverSingleton() {
        Thread.sleep(3000);
        nds = 0.19;
    }

    public double getNds() {
        return nds;
    }
}
