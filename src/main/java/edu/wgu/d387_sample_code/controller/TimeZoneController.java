package edu.wgu.d387_sample_code.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeZoneController {

    private static final ArrayList<String> threeTimes = new ArrayList<>();
    public TimeZoneController(){
    }

    public ArrayList<String> calculateTimes(String timeString) {
        ZoneId zEastern = ZoneId.of("America/New_York");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime ontarioTime = LocalDateTime.parse(timeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        ZonedDateTime etDateTime = ZonedDateTime.of(ontarioTime, zEastern);
        String formattedString = etDateTime.format(formatter) + " ET";
        threeTimes.add(formattedString);
        System.out.println("Local Time added");

        ZonedDateTime mtDateTime = convertToTimeZone(etDateTime, "America/Denver");
        formattedString = mtDateTime.format(formatter) + " MT";
        threeTimes.add(formattedString);
        System.out.println("MT Time added");

        ZonedDateTime utcDateTime = convertToTimeZone(etDateTime, "UTC");
        formattedString = utcDateTime.format(formatter) + " UTC";
        threeTimes.add(formattedString);
        System.out.println("UTC Time added");
        return threeTimes;
    }

    @GetMapping("/times")
    public ArrayList<String> SendCalculatedTimes() {
        System.out.print("CONTROLLER SENDING:\n");
        for (String string : threeTimes) {
            System.out.println(string);
        }
        return threeTimes;
    }


    public ZonedDateTime convertToTimeZone(ZonedDateTime sourceDateTime, String targetZoneId) {
        ZoneId targetZone = ZoneId.of(targetZoneId);
        return sourceDateTime.withZoneSameInstant(targetZone);
    }
}

