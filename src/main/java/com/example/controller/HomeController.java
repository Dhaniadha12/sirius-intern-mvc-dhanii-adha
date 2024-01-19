package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.MobilService;
import com.example.entity.Mobil;

@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private MobilService mobilService;

    @GetMapping
    public String welcome(Model model){
        String messages = "welcome";
        model.addAttribute("msg", messages);
        model.addAttribute("mobils", mobilService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("mobil", new Mobil());
        return "add";
    }

    @PostMapping("/save")
    public String save(Mobil mobil){
        mobilService.addMobil(mobil);
        return "redirect:/mobils";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        mobilService.deleteById(id);
        return "redirect:/mobils";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("mobil", mobilService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Mobil mobil){
        mobilService.updateMobil(mobil);
        return "redirect:/mobils";
    }       
}
