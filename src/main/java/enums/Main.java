package enums;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Igor", MaritalStatus.MARRIED);
        System.out.println("person = " + person.getStatus());

    }
}
