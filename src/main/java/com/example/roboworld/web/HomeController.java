package com.example.roboworld.web;

import com.example.roboworld.model.dto.ReviewAddDto;
import com.example.roboworld.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/review/add")
    public String addReview(@Valid ReviewAddDto reviewAddDto, RedirectAttributes redirectAttributes,
                            BindingResult bindingResult,@AuthenticationPrincipal UserDetails userDetails){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("reviewAddDto", reviewAddDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.reviewAddDto",
                            bindingResult);
            return "redirect:/";
        }
        reviewService.addReview(reviewAddDto, userDetails);

        return "redirect:/";
    }

    @ModelAttribute
    public ReviewAddDto reviewAddDto(){
        return new ReviewAddDto();
    }
    @GetMapping("/about-us")
    public String aboutUs(){
        return "about-us";
    }


}
