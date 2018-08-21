package heroes;

import lombok.AccessLevel;
import lombok.Setter;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author Evgeny Borisov
 */
public class King extends Character {

    @Setter(AccessLevel.PROTECTED)
    private Weapon weapon = new Sword();

    @Override
    public KickResult kick(Character enemy) {
        return weapon.kick(this,enemy);
    }

    @Override
    protected void initState() {
        setHp(RandomFactory.getInstance().getNumberBetween(5,15));
        setPower(RandomFactory.getInstance().getNumberBetween(5,15));
    }
}
