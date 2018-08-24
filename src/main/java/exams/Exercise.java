package exams;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Exercise {
    private int a;
    private int b;
    private Operation operation;
    private int answer;

    @Override
    public String toString() {
        return a + " " + operation + b + " = " + answer;
    }
}
