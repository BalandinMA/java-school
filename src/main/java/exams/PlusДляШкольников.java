package exams;

/**
 * @author Evgeny Borisov
 */
public class PlusДляШкольников implements ExerciseGenerator {
    private ExerciseGeneratorAssistant assistant = new ExerciseGeneratorAssistantForStandardGenerators(0, 100);

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.PLUS);
        exercise.setAnswer(exercise.getA()+exercise.getB());
        return exercise;
    }
}
