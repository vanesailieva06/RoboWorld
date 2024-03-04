package com.example.roboworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    @GetMapping("/sixToEight")
    public String sixToEight(){
        return "courses6-8";
    }
    @GetMapping("/nineToTwelve")
    public String nineToTwelve(){
        return "courses9-12";
    }
    @GetMapping("/thirteenToFifteen")
    public String thirteenToFifteen(){
        return "courses13-15";
    }
    @GetMapping("/sixteenToEighteen")
    public String sixteenToEighteen(){
        return "courses16-18";
    }

}
