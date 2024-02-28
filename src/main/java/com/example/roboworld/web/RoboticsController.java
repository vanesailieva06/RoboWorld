package com.example.roboworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/robotics")
public class RoboticsController {

    @GetMapping("/etymology")
    public String etymology(){
        return "etymology";
    }
    @GetMapping("/history")
    public String history(){
        return "history";
    }
    @GetMapping("/directions")
    public String directions(){
        return "directions";
    }
    @GetMapping("/usage")
    public String usage(){
        return "usage";
    }
    @GetMapping("/components")
    public String components(){
        return "components";
    }

}
