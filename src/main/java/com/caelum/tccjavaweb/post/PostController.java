package com.caelum.tccjavaweb.post;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Standard Layout System with Fragment Expressions usage example
 */
@Controller
@Secured("ROLE_USER")
class PostController {

    private final PostService postService;

    PostController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute("module")
    public String module() {
        return "posts";
    }

    @RequestMapping(value = "post", method = RequestMethod.GET)
    public String posts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/post-list";
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String post(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.findOne(id));
        return "post/post";
    }
}
