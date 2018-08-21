package lombok_examples;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;

import static java.lang.Math.*;

/**
 * @author Evgeny Borisov
 */
@Slf4j
public class Main {



    @SneakyThrows
    public static void main(String[] args) {


        Person ivan = Person.builder().age(12).name("Ivan").beer("Baltika",2).beer("Leff",1)
                .salary(20000).build();
        int x;
    }
}
