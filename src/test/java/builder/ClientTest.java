package builder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ClientTest {

    @Test(expected = IllegalStateException.class)
    public void testThatSalaryIsMandatory() {
        Client.Builder builder = Client.builder();
        Client client = builder.name("Natasha").age(18).build();
    }

    @Test(expected = AlreadyInUseException.class)
    public void builderCannotBeUsedMoreThanOnce() {
        Client.Builder builder = Client.builder();
        builder.salary(2000).build();
        builder.salary(3000).build();
    }
}





