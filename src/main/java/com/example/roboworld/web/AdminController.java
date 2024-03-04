package com.example.roboworld.web;

import com.example.roboworld.service.ReviewService;
import com.example.roboworld.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    private final ReviewService reviewService;
    private final UserService userService;

    public AdminController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return "redirect:/";
    }

    @GetMapping("/users/profiles")
    public String profiles(Model model){
        model.addAttribute("users", userService.getAll());
        return "profiles-admin";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return "redirect:/users/profiles";
    }


}
