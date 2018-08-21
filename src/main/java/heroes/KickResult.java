package heroes;

import lombok.Builder;
import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class KickResult {

    private int hpDamage;
    private int powerDamage;
}
