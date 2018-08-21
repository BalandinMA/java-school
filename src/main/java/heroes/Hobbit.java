package heroes;

/**
 * @author Evgeny Borisov
 */

public class Hobbit extends Character {
    @Override
    public KickResult kick(Character enemy) {
        cry();
        return KickResult.builder().build();
    }

    @Override
    protected void initState() {
        setHp(3);
        setPower(0);
    }

    private void cry() {
        System.out.println("Aua uaa uau");
    }
}
