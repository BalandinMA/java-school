package my_spring;


/**
 * @author Evgeny Borisov
 */
public class IRobot {
    private Speaker speaker = new ConsoleSpeaker();
    private Cleaner cleaner = new CleanerImpl();

    public void cleanRoom(){
        speaker.speak("Я начал работать!!!");
        cleaner.clean();
        speaker.speak("Я закончил работать!!!");
    }
}
