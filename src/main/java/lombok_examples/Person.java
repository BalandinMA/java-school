package lombok_examples;

import lombok.*;
import lombok.experimental.Wither;

import java.util.Map;
import java.util.Objects;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Person {
    private Integer age;




    @NonNull
    private String name;
    private int salary;
    @Singular
    private Map<String,Integer> beers;

}
