package ru.stas.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondControllers {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
