package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        //40 lines of code
        return "welcome " + mailInfo.getClientName();
    }

    @Override
    public int getMyCode() {
        return 1;
    }
}
