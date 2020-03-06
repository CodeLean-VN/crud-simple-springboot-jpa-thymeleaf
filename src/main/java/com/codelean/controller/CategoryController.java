package com.codelean.controller;

import com.codelean.model.Category;
import com.codelean.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category/list")
    public String greeting(Model model) {
        model.addAttribute("list", categoryRepository.findAll());
        return "/category/list";
    }

    @GetMapping("/category/create")
    public String createUI(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/category/create")
    public String storeEntity(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryRepository.save(category);
        redirectAttributes.addAttribute("msg", "Save successfuly!!");
        return "redirect:/category/list";
    }

}