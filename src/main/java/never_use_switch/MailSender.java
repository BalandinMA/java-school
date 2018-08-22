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
                MailCode annotation = generatorClass.getAnnotation(MailCode.class);
                if (annotation == null) {
                    throw new IllegalStateException("each class which impl " + MailGenerator.class.getSimpleName() + " must be marked with annotation" + MailCode.class.getName());
                }
                int mailCode = annotation.value();
                MailGenerator mailGenerator = generatorClass.newInstance();
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
        MailGenerator mailGenerator = generatorMap.getOrDefault(mailCode, mailInfo1 -> {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        });

        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);

    }

    private void send(String html,MailInfo mailInfo) {
        //20 lines of code
        System.out.println("Sending to "+mailInfo.getClientMail());
        System.out.println("html = " + html);
    }
}







