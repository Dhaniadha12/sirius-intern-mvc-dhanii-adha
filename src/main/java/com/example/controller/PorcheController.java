package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.MobilService;
import com.example.Service.PorcheService;
import com.example.entity.Porche;

@Controller
@RequestMapping("/porche") 
public class PorcheController{

    @Autowired
    private PorcheService porcheService;

    @Autowired
    private MobilService mobilService;


    @GetMapping
    public String welcome(Model model) {
        String messages = "welcome";
        model.addAttribute("msg", messages);
        model.addAttribute("porsches", porcheService.findAll());
        return "porche/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("porche", new Porche());
        model.addAttribute("listMobil", mobilService.findAll());
        return "porche/add";
    }

    @PostMapping("/save")
    public String save(Porche porche) {
        porcheService.addPorche(porche);
        return "redirect:/porche"; 
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        porcheService.deleteById(id);
        return "redirect:/porche"; 
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("porche", porcheService.findById(id));
        model.addAttribute("listMobil", mobilService.findAll());
        return "porche/edit";
    }

    @PostMapping("/update")
    public String update(Porche porche) {
        porcheService.updatePorche(porche);
        return "redirect:/porche"; 
    }

}
