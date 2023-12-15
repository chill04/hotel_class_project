package edu.wgu.d387_sample_code.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class GreetingTranslationService {

    public String createWelcomeMessage(Locale locale, MessageSource messageSource) {

        String localGreeting = messageSource.getMessage("welcomeMessage", null, locale);
        System.out.print(localGreeting + " retrieved \n");

        return localGreeting;
    }
}


