package com.yharif.impexformatter.service;

import java.util.HashMap;
import java.util.List;

public interface ImpexFormatterService {

	public HashMap<String, String> parseHeaderInfo(String header);
	
	public List<String> parseHeaderColumns(String header);

	public HashMap<String, String[]> parseContent(String content);

	public HashMap<String, String> parseMacros(String macros);

}
