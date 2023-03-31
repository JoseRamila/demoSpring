package com.desarrollo.demoSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    String index() {
        return "index";
    }

}
