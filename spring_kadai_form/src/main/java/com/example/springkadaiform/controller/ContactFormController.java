package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	@GetMapping("/form")
	public String first(Model model) {
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		return "contactFormView";
	}
	
	@PostMapping("/confirm")
	public String confirmForm(RedirectAttributes redirectAttributes,
	                          @Validated ContactForm form, BindingResult result, Model model) {

	    if (result.hasErrors()) {
	        redirectAttributes.addFlashAttribute("contactForm", form);
	        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
	        return "redirect:/form";
	    }

	    model.addAttribute("name", form.getName());
	    model.addAttribute("email", form.getEmail());
	    model.addAttribute("message", form.getMessage());

	    return "confirmView";
	}
}