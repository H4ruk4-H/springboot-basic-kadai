package com.example.springkadaiform.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	@GetMapping("/form")
	public String first(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contactFormView";
	}
	
	@PostMapping("/form")
	public String confirmForm(
		    @ModelAttribute("contactForm") @Valid ContactForm form,
		    BindingResult bindingResult,
		    Model model) {

		    if (bindingResult.hasErrors()) {
		        return "contactFormView";
		    }

		    // 明示的にゲッターを使って値を渡す（←課題条件対応）
		    model.addAttribute("name", form.getName());
		    model.addAttribute("email", form.getEmail());
		    model.addAttribute("message", form.getMessage());

		    return "confirmView";
		}
}