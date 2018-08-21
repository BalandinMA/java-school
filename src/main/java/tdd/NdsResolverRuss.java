package tdd;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class NdsResolverRuss implements NdsResolver {
    private double nds;

    @SneakyThrows
    public NdsResolverRuss() {
        Thread.sleep(3000);
        nds = 0.19;

    }

    @Override
    public double getNds() {
        return nds;
    }
}
