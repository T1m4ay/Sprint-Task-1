package com.example.springsecondtask.controller;

import com.example.springsecondtask.model.ApplicationRequest;
import com.example.springsecondtask.repository.ApplicationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ApplicationRequestRepository applicationRequestRepository;

    @GetMapping("/")
    public String home(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "index";
    }

    @GetMapping("/new-application")
    public String newApplication(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "new-application";
    }

    @GetMapping("/processed-application")
    public String processedApplication(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "processed-application";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable("id") Long id, Model model){
        ApplicationRequest applicationRequest = applicationRequestRepository.getById(id);
        model.addAttribute("applicationRequest", applicationRequest);
        return "details";
    }

    @GetMapping("/details/procces-application/{id}")
    public String proccesApplication(@PathVariable("id") Long id){
        ApplicationRequest applicationRequest = applicationRequestRepository.getById(id);
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/processed-application";
    }

    @GetMapping("/details/delete-application/{id}")
    public String deleteApplication(@PathVariable("id") Long id){
        applicationRequestRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add-application")
    public String addApplicationPage(){
        return "add-application";
    }

    @PostMapping("/add-application")
    public String addApplication(ApplicationRequest applicationRequest){
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/";
    }
}
