package edu.wgu.d387_sample_code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @GetMapping("/")
    public String redirectToAngularApp() {
        return "please visit application page at localhost:4200";
//        return "redirect";
    }
}
