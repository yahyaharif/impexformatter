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
	public HashMap<String, String[]> parseContent(String content) {
		String[] splitContent = content.split("\r\n");
		HashMap<String, String[]> mapContent = new HashMap<String, String[]>();
		for (int i = 0; i < splitContent.length; i++) {
			if (splitContent[i].equals(""))
				splitContent[i] = "-";
			mapContent.put("line" + i, splitContent[i].split(";"));
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
