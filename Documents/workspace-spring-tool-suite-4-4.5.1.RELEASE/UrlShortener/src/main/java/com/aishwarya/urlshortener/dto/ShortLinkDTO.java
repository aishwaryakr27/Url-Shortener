package com.aishwarya.urlshortener.dto;

public class ShortLinkDTO {
	
	private String shortLink;

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public ShortLinkDTO(String shortLink) {
		super();
		this.shortLink = shortLink;
	}

	public ShortLinkDTO() {
		
	}

	   
}
