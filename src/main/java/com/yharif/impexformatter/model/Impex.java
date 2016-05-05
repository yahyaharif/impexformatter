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

	public String getiMacros() {
		return iMacros;
	}

	public void setiMacros(String iMacros) {
		this.iMacros = iMacros;
	}

	public String getiHeader() {
		return iHeader;
	}

	public void setiHeader(String iHeader) {
		this.iHeader = iHeader;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}

}
