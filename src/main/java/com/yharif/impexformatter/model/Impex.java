package com.yharif.impexformatter.model;

public class Impex {
	private String macros;
	private String header;
	private String content;

	public Impex(String macros, String header, String content) {
		super();
		this.macros = macros;
		this.header = header;
		this.content = content;
	}

	public Impex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMacros() {
		return macros;
	}

	public void setMacros(String macros) {
		this.macros = macros;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
