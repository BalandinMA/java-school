package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClientName();
    }

    @Override
    public int getMyCode() {
        return 3;
    }
}
