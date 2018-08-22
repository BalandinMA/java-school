package exceptions;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class AndreyServiceImpl implements AndreyService {
    @Override
    @SneakyThrows
    public void doAndrey() {
        Thread.sleep(1000);
        System.out.println("Андрей, ты зануда!!!");
    }

    public static void main(String[] args) {
        AndreyService service = new AndreyServiceImpl();
        service.doAndrey();
    }
}
