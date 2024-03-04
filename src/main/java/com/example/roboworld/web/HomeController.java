package com.example.roboworld.web;

import com.example.roboworld.service.ReviewService;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.data.domain.Pageable;

@Controller
public class HomeController {
    private final ReviewService reviewService;

    public HomeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String index(Model model, @PageableDefault(size = 3, sort = "id") Pageable pageable){

        model.addAttribute("reviews",reviewService.getAllReviews(pageable));
        return "index";
    }

    @GetMapping("/about-us")
    public String aboutUs(){
        return "about-us";
    }
}
