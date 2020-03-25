package org.launchcode.makeupchangeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("")
    public String welcome(Model model) {
        model.addAttribute("title", "Makeup ChangeUp");
        return "index";
    }
}
