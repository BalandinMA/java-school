package my_spring;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        System.out.println(iRobot.getClass().getName());
        while (true) {
            iRobot.cleanRoom();
            Thread.sleep(1000);
        }
       /* BeerService beerService = ObjectFactory.getInstance().createObject(BeerService.class);
        beerService.a();*/
    }
}
