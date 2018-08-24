package exams;

import lombok.Builder;
import lombok.Singular;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Builder
public class Examinator {
    @Singular
    private List<ExerciseGenerator> generators;

    private static final DataFactory dataFactory = new DataFactory();

    public List<Exercise> createExam(int amount) {
        List<Exercise> exercises = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Exercise exercise = dataFactory.getItem(generators).generate();
            exercises.add(exercise);
        }
        return exercises;
    }
}






