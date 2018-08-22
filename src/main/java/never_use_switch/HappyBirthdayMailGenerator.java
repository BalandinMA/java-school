package never_use_switch;

/**
 * @author Evgeny Borisov
 */
@MailCode(3)
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClientName();
    }


}
