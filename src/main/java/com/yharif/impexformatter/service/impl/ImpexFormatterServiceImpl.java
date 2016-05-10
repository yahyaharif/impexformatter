package com.yharif.impexformatter.service.impl;

import com.yharif.impexformatter.service.ImpexFormatterService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ImpexFormatterServiceImpl implements ImpexFormatterService {

	@Override
	public HashMap<String, String> parseHeaderInfo(String header) {

		HashMap<String, String> mapHeaderInfo = new HashMap<String, String>();

		// Get impex mode
		String mode = null;
		mode = StringUtils.substring(header, 0, StringUtils.indexOf(header, " "));
		mapHeaderInfo.put("mode", mode);

		// get impex type
		String type = null;
		type = StringUtils.substring(header, StringUtils.indexOf(header, " ") + 1, StringUtils.indexOf(header, ";"));
		mapHeaderInfo.put("type", type);

		return mapHeaderInfo;
	}

	@Override
	public List<String> parseHeaderColumns(String header) {

		List<String> mapHeaderColumns = new ArrayList<String>();

		// Get impex attributes
		String trimmedHeader = StringUtils.replace(header, " ", "");
		String[] attributes = StringUtils.substring(trimmedHeader, StringUtils.indexOf(trimmedHeader, ";") + 1)
				.split(";");
		for (int i = 0; i < attributes.length; i++) {
			mapHeaderColumns.add(attributes[i]);
		}

		return mapHeaderColumns;
	}

	@Override
	public HashMap<String, String[]> parseContent(String header, String content) {
		String oneLineContent = StringUtils.replace(content, "\r\n", "");
		int nbColumns = parseHeaderColumns(header).size();
		int counter = 0;
		int start = 0;
		HashMap<String, String[]> mapContent = new HashMap<String, String[]>();
		for (int i = 0; i < oneLineContent.length(); i++) {
			if (oneLineContent.charAt(i) == ';') {
				counter++;
				if (counter == nbColumns) {
					mapContent.put("header" + i, StringUtils.substring(oneLineContent, start, i + 1).split(";"));
					start = i + 1;
					counter = 0;
				}
			}

		}
		return mapContent;
	}

	@Override
	public HashMap<String, String> parseMacros(String macros) {
		String noSemiColon = StringUtils.replace(macros, ";", "");
		String trimmedMacro = StringUtils.replace(noSemiColon, " ", "");
		String oneLineMacro = StringUtils.replace(trimmedMacro, "\r\n", "");
		String[] lineMacros = oneLineMacro.split("\\$");
		HashMap<String, String> mapMacros = new HashMap<String, String>();
		for (int i = 0; i < lineMacros.length; i++) {
			if (!lineMacros[i].equals(""))
				mapMacros.put(StringUtils.substringBefore(lineMacros[i], "="),
						StringUtils.substringAfter(lineMacros[i], "="));
		}

		return mapMacros;
	}

}
