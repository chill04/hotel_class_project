package edu.wgu.d387_sample_code.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class GreetingTranslationService {

//    @Autowired
//    MessageSource messageSource;

    public String createWelcomeMessage(Locale locale, MessageSource messageSource) {
//        MessageSource messageSource;
//        Locale locale = Locale.CANADA_FRENCH;
//        locale = LocaleContextHolder.getLocale();
        String localGreeting = messageSource.getMessage("welcomeMessage", null, locale);
        System.out.print(localGreeting + " retrieved \n");
//        String[] greetingsArray = {localGreeting};
        return localGreeting;
    }
}


