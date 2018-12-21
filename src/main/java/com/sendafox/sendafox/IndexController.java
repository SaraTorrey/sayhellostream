package com.sayhellostream.sayhellostream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(name = "index")
    public String index() {

        return "index";
    }

    @PostMapping(value = "send")
    public String send(@RequestParam String first, @RequestParam String last, @RequestParam String phone, @RequestParam String body) {

        TwillioSender.send(phone, "+19252332108", body);

        return "index";
    }

    @GetMapping(value = "landing")
    public String landing() {

        return "landing";
    }
    
    @GetMapping(value = "sendText")
    public String sendText() {

        return "sendText";
    }
}
