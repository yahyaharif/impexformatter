package com.yharif.impexformatter.model;

public class Impex {
	private String iMacros;
	private String iHeader;
	private String iContent;

	public Impex(String iMacros, String iHeader, String iContent) {
		super();
		this.iMacros = iMacros;
		this.iHeader = iHeader;
		this.iContent = iContent;
	}

	public Impex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIMacros() {
		return iMacros;
	}

	public void setIMacros(String iMacros) {
		this.iMacros = iMacros;
	}

	public String getIHeader() {
		return iHeader;
	}

	public void setIHeader(String iHeader) {
		this.iHeader = iHeader;
	}

	public String getIContent() {
		return iContent;
	}

	public void setIContent(String iContent) {
		this.iContent = iContent;
	}

}
