package never_use_switch;

/**
 * @author Evgeny Borisov
 */
@MailCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        //40 lines of code
        return "don't call us we call you ";
    }


}
