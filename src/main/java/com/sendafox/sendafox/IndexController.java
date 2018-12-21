package com.sayhellostream.sayhellostream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @PostMapping(value = "send")
    public String send(@RequestParam String first, @RequestParam String last, @RequestParam String phone, @RequestParam String body) {

        TwillioSender.send(phone, "+19252332108", body);

        return "mainTemplate";
    }

    @GetMapping(value = "landing")
    public String landing() {

        return "landing";
    }
    
    @GetMapping(value = "sendText1")
    public String sendText() {

        return "sendText";
    }

    // Pages

    @GetMapping(value = "userProfile")
    public String userProfile() {

        return "userProfile";
    }

    @GetMapping(value = "1")
    public String one() {

        return "1";
    }

    @GetMapping(value = "sendEmail")
    public String sendEmail() {

        return "sendEmail";
    }
}
