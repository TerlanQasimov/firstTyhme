package com.orient.firstthyme;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    WorkRepository workRepository;

    @GetMapping("/")
    public String home(){

        return "index";

    }

    @GetMapping("/works")
    public String works(Model model){
        List<Work> works = workRepository.findAll();
        model.addAttribute("works", works);
        return "works";
    }

    @GetMapping("/create")
    public String create(Model model){
        Work work = new Work();
        model.addAttribute("work", work);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Work work){

        workRepository.save(work);

        return "redirect:/works";

    }


}
