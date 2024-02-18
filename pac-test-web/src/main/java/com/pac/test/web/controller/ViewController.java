package com.pac.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController {
	
	@GetMapping("homepage")
	public ModelAndView homepage() {
		ModelAndView view = new ModelAndView("frontend/homepage.html");
		return view;
	}
	
	@GetMapping("register")
	public ModelAndView register() {
		ModelAndView view = new ModelAndView("frontend/register.html");
		return view;
	}
	
	@GetMapping("balanceinformation")
	public ModelAndView balanceinformation() {
		ModelAndView view = new ModelAndView("frontend/balanceinformation.html");
		return view;
	}
	
	@GetMapping("transaction")
	public ModelAndView transaction() {
		ModelAndView view = new ModelAndView("frontend/transaction.html");
		return view;
	}
	
	@GetMapping("transactionhistory")
	public ModelAndView transactionhistory() {
		ModelAndView view = new ModelAndView("frontend/historytransaction.html");
		return view;
	}

}
