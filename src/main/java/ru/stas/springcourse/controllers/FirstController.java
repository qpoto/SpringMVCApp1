package ru.stas.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        //System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("bye")
    public String goodBuePage() {
        return "first/bye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        double result = 0;
        switch (action) {
            case "multi":
                result = a * b;
                break;
            case "div":
                result = (double) a / b;
                break;
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
