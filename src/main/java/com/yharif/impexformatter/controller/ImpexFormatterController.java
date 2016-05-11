package com.yharif.impexformatter.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yharif.impexformatter.model.Impex;
import com.yharif.impexformatter.service.ImpexFormatterService;

@Controller
public class ImpexFormatterController {

	@Autowired
	private ImpexFormatterService impexFormatterService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("form", "command", new Impex());
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute("formattedImpex") Impex impex, ModelMap model) {

		// Header validation
		Pattern patternHeader = Pattern.compile(".*?(\\s+).*?(;)");
		Matcher matcherHeader = patternHeader.matcher(impex.getIHeader());
		// Macro validation
		Pattern patternMacro = Pattern.compile("");
		Matcher matcherMacro = patternMacro.matcher(impex.getIMacros());
		// Content validation
		Pattern patternContent = Pattern.compile("");
		Matcher matcherContent = patternContent.matcher(impex.getIContent());

		if (matcherHeader.find()) {
			model.addAttribute("IMacros", impexFormatterService.parseMacros(impex.getIMacros()));
			model.addAttribute("IHeaderInfo", impexFormatterService.parseHeaderInfo(impex.getIHeader()));
			model.addAttribute("IHeaderColumns", impexFormatterService.parseHeaderColumns(impex.getIHeader()));
			model.addAttribute("IContent", impexFormatterService.parseContent(impex.getIContent()));

			return "result";
		}

		return "error";
	}

}
