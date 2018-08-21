package reflections_example;

/**
 * @author Evgeny Borisov
 */
public class DBService {

    public DBService(String name) {
        System.out.println("name = " + name);
    }

    private int age;

    @RunThisMethod(repeat = 10)
    public void doX(){
        System.out.println("XXXXXXXXXXXX");
    }

    public void runABC() {
        System.out.println("ABC");
    }

    public void runZZZ() {
        System.out.println(age);
    }
}
