package exams;

import heroes.RandomFactory;

import static exams.Operation.MINUS;

/**
 * @author Evgeny Borisov
 */
public class MinusДляДетскогоСада implements ExerciseGenerator{


    @Override
    public Exercise generate() {
        RandomFactory randomFactory = RandomFactory.getInstance();
        int a = randomFactory.getNumberBetween(1, 10);
        int b = randomFactory.getNumberBetween(0, a+1);
        return Exercise.builder().a(a).b(b).operation(MINUS).answer(a - b).build();
    }
}
