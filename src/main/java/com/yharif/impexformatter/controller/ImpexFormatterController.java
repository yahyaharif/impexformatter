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
		Pattern pattern = Pattern.compile(".*?(\\s+).*?(;)");
		Matcher matcher = pattern.matcher(impex.getIHeader());
		if (StringUtils.isNotBlank(impex.getIHeader()) && matcher.find() && StringUtils
				.length(StringUtils.substring(impex.getIHeader(), StringUtils.indexOf(impex.getIHeader(), ";"))) > 0) {
			model.addAttribute("IMacros", impexFormatterService.parseMacros(impex.getIMacros()));
			model.addAttribute("IHeaderInfo", impexFormatterService.parseHeaderInfo(impex.getIHeader()));
			model.addAttribute("IHeaderColumns", impexFormatterService.parseHeaderColumns(impex.getIHeader()));
			model.addAttribute("IContent", impex.getIContent());

			return "result";
		}
		return "error";
	}

}
