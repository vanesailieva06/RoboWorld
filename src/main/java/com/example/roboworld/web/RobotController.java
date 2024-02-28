package com.example.roboworld.web;
import com.example.roboworld.model.dto.RobotAddDto;
import com.example.roboworld.service.RobotService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/robots")
public class RobotController {
    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping("/add")
    public String add(){
        return "add-robot";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid RobotAddDto robotAddDto,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult, @AuthenticationPrincipal UserDetails user){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("robotAddDto", robotAddDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.robotAddDto",
                            bindingResult);
            return "redirect:/robots/add";
        }

        robotService.addRobot(robotAddDto, user);

        return "redirect:/";
    }

    @ModelAttribute
    public RobotAddDto robotAddDto(){
        return new RobotAddDto();
    }

    @GetMapping("/all")
    public String allRobots(Model model){
        model.addAttribute("robots", robotService.getAll());
        return "all-robots";
    }
}
