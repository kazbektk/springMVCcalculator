package org.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value="name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(){
        return "first/calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("a") Integer a,
                            @RequestParam("b") Integer b,
                            @RequestParam("action") String action,
                            Model model){
        double result;

        switch (action){
            case "multiplication":
                result = a*b;
                break;
            case "addition":
                result = a+b;
                break;
            case "subtraction":
                result = a-b;
                break;
            case "division":
                result = a/(double)b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", "result: " + result);

        return "first/calculator";
    }
}
