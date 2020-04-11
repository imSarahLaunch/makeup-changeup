package org.launchcode.makeupchangeup.controllers;

import org.launchcode.makeupchangeup.models.MakeupItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("makeupItems")
public class MakeupItemController {

    private static List<MakeupItem> items = new ArrayList<>();

    @GetMapping
    public String displayAllItems(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: All Items");
        model.addAttribute("items", items);
        return "makeupItems/index";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Makeup ChangeUp: Add Item");
        return "makeupItems/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@RequestParam String itemName, @RequestParam String purchaseDate,
                                     @RequestParam String expiration) {
        items.add(new MakeupItem(itemName, purchaseDate, expiration));
        return "redirect:";
    }
}
