package my_spring;

import javax.annotation.Resource;

/**
 * @author Evgeny Borisov
 */
public class BeerServiceImpl implements BeerService {

    @Override
    public void drinkBeer() {
        System.out.println("Blanche is the best");
    }

    @Override
    public void goToToilet() {
        System.out.println("pssssssssss");
    }

    @Override
    public void a() {
        System.out.println("AAAAAAAAAA");
    }

    @Override
    @Benchmark
    public void b() {
        System.out.println("BBBBBBBBBBBBBBBb");
    }
}
