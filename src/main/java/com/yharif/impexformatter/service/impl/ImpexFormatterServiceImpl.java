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
		String trimmedHeader = StringUtils.replace(header, "\\s", "");
		String[] attributes = StringUtils.substring(trimmedHeader, StringUtils.indexOf(trimmedHeader, ";") + 1)
				.split(";");
		for (int i = 0; i < attributes.length; i++) {
			mapHeaderColumns.add(attributes[i]);
		}

		return mapHeaderColumns;
	}

	@Override
	public HashMap<String, String> parseContent(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> parseMacros(String macros) {
		// TODO Auto-generated method stub
		return null;
	}

}
