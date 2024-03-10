package com.example.roboworld.web;

import com.example.roboworld.model.entity.enums.AgeLimit;
import com.example.roboworld.service.CourseService;
import com.example.roboworld.service.LectureService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    private final CourseService courseService;
    private final LectureService lectureService;

    public CoursesController(CourseService courseService, LectureService lectureService) {
        this.courseService = courseService;
        this.lectureService = lectureService;
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
    @GetMapping("/{id}")
    public String courseDetails(@PathVariable Long id, Model model,  @PageableDefault(size = 4) Pageable pageable){
        model.addAttribute("lectures", lectureService.getAllByCourseId(id));
        model.addAttribute("courseDetails",courseService.findById(id));
        model.addAttribute("otherCourses", courseService.getAllWithoutThis(id, pageable));
        return "courses-details";
    }

    @GetMapping("/signInUp/{id}")
    public String signInUp(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails, Model model){
        courseService.signInUp(id, userDetails);
        return "redirect:/courses/"+ id;
    }
}
