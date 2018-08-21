package tdd;

import lombok.Setter;

/**
 * @author Evgeny Borisov
 */
public class TaxCalculator {

    @Setter
    private NdsResolver ndsResolver = new NdsResolverRuss();

    public double withNDS(double price) {
        double nds = ndsResolver.getNds();
        return price * nds+price;
    }

}
