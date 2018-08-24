package exams;

/**
 * @author Evgeny Borisov
 */
public class MulltiplyДляШкольников implements ExerciseGenerator {
    private ExerciseGeneratorAssistant assistant = new ExerciseGeneratorAssistantForStandardGenerators(0, 10);

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.MULTIPLY);
        exercise.setAnswer(exercise.getA()*exercise.getB());
        return exercise;
    }
}
