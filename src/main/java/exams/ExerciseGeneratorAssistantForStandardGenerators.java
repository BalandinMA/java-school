package exams;

import heroes.RandomFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public class ExerciseGeneratorAssistantForStandardGenerators implements ExerciseGeneratorAssistant {

    private int min,max;

    @Override
    public Exercise generateTemplate() {
        int a = RandomFactory.getInstance().getNumberBetween(min, max);
        int b = RandomFactory.getInstance().getNumberBetween(min, max);
        return Exercise.builder().a(a).b(b).build();
    }
}






