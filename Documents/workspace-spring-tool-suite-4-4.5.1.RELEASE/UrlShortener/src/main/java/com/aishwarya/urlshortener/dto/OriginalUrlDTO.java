package com.aishwarya.urlshortener.dto;

public class OriginalUrlDTO {

	
	private String originalUrl;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public OriginalUrlDTO(String originalUrl) {
		super();
		this.originalUrl = originalUrl;
	}
	public OriginalUrlDTO() {
		
	}
	
}
