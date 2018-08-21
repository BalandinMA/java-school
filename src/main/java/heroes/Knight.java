package heroes;

import lombok.AccessLevel;
import lombok.Setter;

/**
 * @author Evgeny Borisov
 */
public class Knight extends Character {

    @Setter(AccessLevel.PROTECTED)
    private Weapon weapon = new Sword();

    @Override
    public KickResult kick(Character enemy) {
        return weapon.kick(this,enemy);
    }

    @Override
    protected void initState() {
        setHp(RandomFactory.getInstance().getNumberBetween(2,12));
        setPower(RandomFactory.getInstance().getNumberBetween(2,12));
    }
}
