package edu.wgu.d387_sample_code.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class GreetingController {
    private static ArrayList<String> greetings = new ArrayList<String>();
    public GreetingController(){
    }

    public void addGreeting(String newGreeting) {
        greetings.add(newGreeting);
        System.out.print(newGreeting + " Added!\n");
    }

    @GetMapping("/greeting")
    public ArrayList<String> WelcomeController() {
        System.out.print("CONTROLLER SENDING:\n");
        for (String string : greetings) {
            System.out.print(string + "\n");
        }
        return greetings;
    }
}