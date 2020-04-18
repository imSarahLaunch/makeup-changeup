package org.launchcode.makeupchangeup.controllers;

import org.launchcode.makeupchangeup.data.MakeupItemData;
import org.launchcode.makeupchangeup.models.MakeupItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("makeupItems")
public class MakeupItemController {

//    private static List<MakeupItem> items = new ArrayList<>();

    @GetMapping
    public String displayAllItems(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: All Items");
        model.addAttribute("items", MakeupItemData.getAll());
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
        MakeupItemData.add(makeupItem);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteItemForm(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: Delete Items");
        model.addAttribute("items", MakeupItemData.getAll());
        return "makeupItems/delete";
    }

    @PostMapping("delete")
    public String processDeleteItemForm(@RequestParam(required = false) int[] itemIds) {
        if(itemIds != null) {
            for (int id : itemIds) {
                MakeupItemData.remove(id);
            }
        }
        return "redirect:";
    }
}
