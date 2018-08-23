package strategy;

import lombok.Setter;
import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
@Setter
public class RadioAlarm implements Radio,Alarm {
    @Delegate
    private Radio radio = new RadioImpl();
    @Delegate(excludes = AlarmExclusions.class)
    private Alarm alarm = new AlarmImpl();

    public void c(){

    }
}
