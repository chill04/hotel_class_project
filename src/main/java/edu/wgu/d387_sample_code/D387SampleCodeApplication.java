package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.Service.GreetingTranslationService;
import edu.wgu.d387_sample_code.controller.GreetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import java.util.Locale;


@SpringBootApplication
public class D387SampleCodeApplication implements CommandLineRunner {
	@Autowired
	MessageSource messageSource;
	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		GreetingController greetingController = new GreetingController();
		GreetingTranslationService englishTranslationService = new GreetingTranslationService();
		GreetingTranslationService frenchTranslationService = new GreetingTranslationService();
		String englishWelcome = englishTranslationService.createWelcomeMessage(Locale.CANADA, messageSource);
		String frenchWelcome = frenchTranslationService.createWelcomeMessage(Locale.CANADA_FRENCH, messageSource);

		greetingController.addGreeting(englishWelcome);
		greetingController.addGreeting(frenchWelcome);
		greetingController.WelcomeController();
	}
}
