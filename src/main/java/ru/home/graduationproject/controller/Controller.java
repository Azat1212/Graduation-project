package ru.home.graduationproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.home.graduationproject.service.CalculateService;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    private CalculateService service;

    @GetMapping
    public String frontPage(Model model) {
        model.addAttribute("records", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String product, @RequestParam int productAmount, @RequestParam int carbohydratePerAmount) {
        service.add(product, productAmount, carbohydratePerAmount);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewPage(@PathVariable int id, Model model) {
        model.addAttribute("record", service.getById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        model.addAttribute("record", service.getById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit( @PathVariable int id, @RequestParam String product, @RequestParam int productAmount, @RequestParam int carbohydratePerAmount)
    {
        service.updateById(id, product, productAmount, carbohydratePerAmount);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable int id) {
        service.removeById(id);
        return "redirect:/";
    }
}
