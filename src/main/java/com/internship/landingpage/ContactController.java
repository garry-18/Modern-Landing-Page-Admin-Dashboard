package com.internship.landingpage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository repo;

    @ModelAttribute("contact")
    public Contact emptyContact() {
        return new Contact();
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/submit")
    public String handleForm(@ModelAttribute Contact contact, RedirectAttributes redirectAttributes) {
        try {
            logger.info("Received contact form submission from: {}", contact.getEmail());
            repo.save(contact);
            redirectAttributes.addFlashAttribute("success", "Your message has been saved successfully!");
        } catch (Exception e) {
            logger.error("Error saving contact: ", e);
            redirectAttributes.addFlashAttribute("error", "Something went wrong. Please try again.");
        }
        return "redirect:/";
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "contacts";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}