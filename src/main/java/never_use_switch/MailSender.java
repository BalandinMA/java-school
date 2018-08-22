package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private MailDao mailDao = new MailDaoImpl();

    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        switch (mailCode) {
            case 1:
                //50 lines of code which will generate need mail template called Welcome Mail
                System.out.println("Welcome " + mailInfo.getClientName());
                System.out.println("sending to " + mailInfo.getClientMail());
                break;
            case 2:
                //30 lines of code which will generate need mail template called Email callback
                System.out.println("don't call us we call you ");
                System.out.println("sending to " + mailInfo.getClientMail());
                break;
            case 3:

                break;
        }
    }
}
