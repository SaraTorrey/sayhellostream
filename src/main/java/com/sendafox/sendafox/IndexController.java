package com.sayhellostream.sayhellostream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(name = "index")
    public String index() {

        return "index";
    }

    @GetMapping(value = "anotherPage")
    public String anotherPage() {

        return "anotherPage";
    }
}
