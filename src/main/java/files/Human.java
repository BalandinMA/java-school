package files;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@Data
public class Human implements Serializable {
    private String name;

    private transient int age;
}
