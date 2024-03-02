package com.example.roboworld.web;

import com.example.roboworld.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ForumController {

    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/forum/all")
    public String allForums(Model model){
        model.addAttribute("forum", forumService.getAll());
        return "forum";
    }

    @GetMapping("/forum/{id}")
    public String forum(@PathVariable Long id, Model model){

        model.addAttribute("forumDetails", forumService.findById(id));
        model.addAttribute("otherForums", forumService.findForumsWithoutThis(id));
        return "forum-details";
    }


}
