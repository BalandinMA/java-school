package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class TaxCalculatorTest {


    @Test
    public void withNDS() {
        TaxCalculator taxCalculator = new TaxCalculator();

        NdsResolver mock = Mockito.mock(NdsResolver.class);
        Mockito.when(mock.getNds()).thenReturn(0.18);

        taxCalculator.setNdsResolver(mock);
        double withNDS = taxCalculator.withNDS(100);
        Assert.assertEquals(118,withNDS,0.000001);
    }


}