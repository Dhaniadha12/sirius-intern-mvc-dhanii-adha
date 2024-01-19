package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.MobilService;
import com.example.Service.SedanService;
import com.example.entity.Sedan;

@Controller
@RequestMapping("/sedan") 
public class SedanController<sedanService> {

    @Autowired
    private SedanService sedanService;

    @Autowired
    private MobilService mobilService;


    @GetMapping
    public String welcome(Model model) {
        String messages = "welcome";
        model.addAttribute("msg", messages);
        model.addAttribute("sedans", sedanService.findAll());
        return "sedan/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("sedan", new Sedan());
        model.addAttribute("listMobil", mobilService.findAll());
        return "sedan/add";
    }

    @PostMapping("/save")
    public String save(Sedan sedan) {
        sedanService.addSedan(sedan);
        return "redirect:/sedan"; // Ganti redirect ke "/sedan"
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        sedanService.deleteById(id);
        return "redirect:/sedan"; // Ganti redirect ke "/sedan"
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sedan", sedanService.findById(id));
        model.addAttribute("listMobil", mobilService.findAll());
        return "sedan/edit";
    }

    @PostMapping("/update")
    public String update(Sedan sedan) {
        sedanService.updateSedan(sedan);
        return "redirect:/sedan"; // Ganti redirect ke "/sedan"
    }

}