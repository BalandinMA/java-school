package exercise_creator;

import java.util.Random;

public class MinusExerciseGenerator implements ExerciseGenerator {
    private Random random = new Random();

    @Override
    public Exercise generate() {
        int value1 = random.nextInt(100);
        int value2 = random.nextInt(100);

        Exercise exercise = Exercise.builder().
                value1(value1).
                value2(value2).
                operation(Operation.MINUS).
                answer(value1 - value2).
                build();

        return exercise;
    }
}
