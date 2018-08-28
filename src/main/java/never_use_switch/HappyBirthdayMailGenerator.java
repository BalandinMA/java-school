package never_use_switch;

/**
 * @author Evgeny Borisov
 */
@MailCode(3)
@MailCode(4)
@MailCode(5)
@MailCode(6)
@MailCode(7)
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClientName();
    }


}
