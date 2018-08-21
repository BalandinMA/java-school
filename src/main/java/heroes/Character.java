package heroes;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Evgeny Borisov
 */
@Data
public abstract class Character {
    private int hp;
    private int power;

    public abstract KickResult kick(Character enemy);

    protected abstract void initState();

    public Character() {
        initState();
    }

    public boolean isAlive(){
        return hp>0;
    }

    public void decreaseHp(int delta) {
        System.out.println();
        hp -= delta;
    }

    public void decreasePower(int delta) {
        power -= delta;
    }


}
