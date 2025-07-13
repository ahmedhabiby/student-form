package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.student;
import com.ecommerce.demo.repositry.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class studentcontroller {
    @Autowired
    private studentrepo studentrepo;

    public studentcontroller(studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", studentrepo.findAll());
        return "student-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new student());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute student student) {
        studentrepo.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentrepo.findById(id).orElseThrow());
        return "student-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        studentrepo.deleteById(id);
        return "redirect:/";
    }
}
