package heroes;

/**
 * @author Evgeny Borisov
 */
public class Elf extends Character {
    @Override
    public KickResult kick(Character enemy) {
        KickResult.KickResultBuilder resultBuilder = KickResult.builder();
        if (getPower() > enemy.getPower()) {
            resultBuilder.hpDamage(enemy.getHp());
            enemy.setHp(0);
        }else {
            enemy.decreasePower(1);
            resultBuilder.powerDamage(1);
        }
        return resultBuilder.build();
    }

    @Override
    protected void initState() {
        setHp(10);
        setPower(10);
    }
}
