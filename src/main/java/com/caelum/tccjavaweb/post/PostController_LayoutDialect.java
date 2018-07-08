package com.caelum.tccjavaweb.post;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Layout Dialect usage example.
 */
@Controller
@Secured("ROLE_USER")
class PostController_LayoutDialect {

    private final PostService postService;

    PostController_LayoutDialect(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute("module")
    public String module() {
        return "posts-ld";
    }

    @RequestMapping(value = "post-ld", method = RequestMethod.GET)
    public String posts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post-ld/post-list";
    }

    @RequestMapping(value = "post-ld/{id}", method = RequestMethod.GET)
    public String post(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.findOne(id));
        return "post-ld/post";
    }
}
