package com.example.roboworld.web;

import com.example.roboworld.model.dto.UserRegisterDto;
import com.example.roboworld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterDto userRegisterDto,
                                  RedirectAttributes redirectAttributes,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors() || !userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto",
                            bindingResult);
            return "redirect:register";
        }
        boolean isExist = userService.findByUsername(userRegisterDto.getUsername()) != null;
        if (isExist){
            return "redirect:register";
        }

        userService.registerUser(userRegisterDto);

        return "redirect:login";
    }

    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @PostMapping("/login-error")
    public String onFailure(
            @ModelAttribute("username") String username,
            Model model) {

        model.addAttribute("username", username);
        model.addAttribute("bad_credentials", true);

        return "login";
    }
}
