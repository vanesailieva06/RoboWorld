package com.example.roboworld.web;

import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    private final CourseService courseService;

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/sixToEight")
    public String sixToEight(Model model){
        model.addAttribute("course6to8",courseService.getAllByAgeLimit(AgeLimit.SixToEight));
        return "courses6-8";
    }
    @GetMapping("/nineToTwelve")
    public String nineToTwelve(Model model){
        model.addAttribute("course9to12",courseService.getAllByAgeLimit(AgeLimit.NineToTwelve));
        return "courses9-12";
    }
    @GetMapping("/thirteenToFifteen")
    public String thirteenToFifteen(Model model){
        model.addAttribute("course13to15",courseService.getAllByAgeLimit(AgeLimit.ThirteenToFifteen));
        return "courses13-15";
    }
    @GetMapping("/sixteenToEighteen")
    public String sixteenToEighteen(Model model){
        model.addAttribute("course16to18",courseService.getAllByAgeLimit(AgeLimit.SixteenToEighteen));
        return "courses16-18";
    }

}
