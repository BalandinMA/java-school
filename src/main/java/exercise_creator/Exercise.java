package exercise_creator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exercise {
    private int value1;
    private int value2;

    private Operation operation;

    private int answer;
}
