package org.launchcode.makeupchangeup.controllers;

import org.launchcode.makeupchangeup.data.MakeupItemRepository;
import org.launchcode.makeupchangeup.models.MakeupItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("makeupItems")
public class MakeupItemController {

    @Autowired
    private MakeupItemRepository makeupItemRepository;

    @GetMapping
    public String displayAllItems(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: All Items");
        model.addAttribute("items", makeupItemRepository.findAll());
        return "makeupItems/index";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: Add Item");
        model.addAttribute(new MakeupItem());
        return "makeupItems/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@ModelAttribute @Valid MakeupItem makeupItem, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Makeup ChangeUp: Add Item");
            return "makeupItems/add";
        }
        makeupItemRepository.save(makeupItem);
        return "redirect:";
    }

    @GetMapping("delete/{itemId}")
    public String handleDeleteItem(Model model, @PathVariable int itemId) {
        makeupItemRepository.deleteById(itemId);
        return "redirect:../";
    }
}
