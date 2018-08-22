package never_use_switch;

import builder.AlreadyInUseException;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private MailDao mailDao = new MailDaoImpl();
    private Map<Integer, MailGenerator> generatorMap = new HashMap<>();

    @SneakyThrows
    public MailSender() {
        Reflections scanner = new Reflections("never_use_switch");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> generatorClass : classes) {
            if (!Modifier.isAbstract(generatorClass.getModifiers())) {
                MailGenerator mailGenerator = generatorClass.newInstance();
                int mailCode = mailGenerator.getMyCode();
                if(generatorMap.containsKey(mailCode)) {
                    throw new AlreadyInUseException(mailCode + " already in use");
                }
                generatorMap.put(mailCode, mailGenerator);
            }
        }
    }

    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = generatorMap.get(mailCode);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);

    }

    private void send(String html,MailInfo mailInfo) {
        //20 lines of code
        System.out.println("Sending to "+mailInfo.getClientMail());
        System.out.println("html = " + html);
    }
}







