package com.yharif.impexformatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yharif.impexformatter.model.Impex;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ImpexFormatterController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("form", "command", new Impex());
	}


	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute("formattedImpex") Impex impex, ModelMap model) {
		model.addAttribute("macros", impex.getMacros());
		model.addAttribute("header", impex.getHeader());
		model.addAttribute("content", impex.getContent());

		return "result";
	}

}
