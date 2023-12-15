package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.Service.GreetingTranslationService;
import edu.wgu.d387_sample_code.controller.GreetingController;
import edu.wgu.d387_sample_code.controller.TimeZoneController;
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
		// One instance of GreetingController
		GreetingController greetingController = new GreetingController();
		// Two threads of GreetingTranslation Service
		GreetingTranslationService englishTranslationService = new GreetingTranslationService();
		GreetingTranslationService frenchTranslationService = new GreetingTranslationService();
		// Call each thread
		String englishWelcome = englishTranslationService.createWelcomeMessage(Locale.CANADA, messageSource);
		String frenchWelcome = frenchTranslationService.createWelcomeMessage(Locale.CANADA_FRENCH, messageSource);
		// Add threads to Controller
		greetingController.addGreeting(englishWelcome);
		greetingController.addGreeting(frenchWelcome);
		// Send array to API/GREETING
		greetingController.WelcomeController();

		TimeZoneController timeZoneController = new TimeZoneController();
		String timeString = "2023-01-01T10:00:00";
		timeZoneController.calculateTimes(timeString);
		timeZoneController.SendCalculatedTimes();
	}
}
