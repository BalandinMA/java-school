package exams;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Examinator examinator = Examinator.builder().generator(new MinusДляДетскогоСада())
                .generator(new PlusДляШкольников()).build();

        List<Exercise> exam = examinator.createExam(10);
        for (Exercise exercise : exam) {
            System.out.println("exercise = " + exercise);
        }
    }
}
