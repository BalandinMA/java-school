package exercise_creator;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<ExerciseGenerator> typeList = new LinkedList<>();
        typeList.add(new MinusExerciseGenerator());
        typeList.add(new PlusExerciseGenerator());
        for (int i = 0; i < 10; i++) {
            System.out.println(typeList.get(RandomHolder.getInstance().nextInt(2)).generate());
        }
    }
}
