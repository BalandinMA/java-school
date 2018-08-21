package gc;

import lombok.SneakyThrows;
import lombok_examples.Person;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;

/**
 * @author Evgeny Borisov
 */
public class Main {

    public static String VERSION = "8";

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String s = sb.append("").toString();
        String str = "java" + VERSION + "the" + "best";

        Thread thread = new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                int i=0;
                while (true) {
                    i++;
                    System.out.println(123);
                    Thread.sleep(100);
                    if (i > 20) {
                        Thread.currentThread().setDaemon(true);
                    }
                }
            }
        });
//        thread.setDaemon(true);
        thread.start();
/*        DataFactory dataFactory = new DataFactory();
        ArrayList<Person> people = new ArrayList<>();
        while (true) {
            String name = dataFactory.getName();
            Person person = Person.builder().name(name).build();
            if (dataFactory.getNumberBetween(0, 1000) == 10) {
                people.add(person);
            }
        }*/
    }
}
