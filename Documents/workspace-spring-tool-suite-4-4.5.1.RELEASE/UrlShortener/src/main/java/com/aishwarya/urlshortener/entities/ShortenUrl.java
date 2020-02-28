package com.aishwarya.urlshortener.entities;

import javax.persistence.*;


@Entity
public class ShortenUrl {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "ORIGINAL_URL")
	private String original_link;
	
	@Column(name = "SHORT_KEY")
	private String short_link;
	
	

	public ShortenUrl(String original_link) {
		this.original_link = original_link;
	}
	public ShortenUrl(String original_link, String short_link) {
		this.original_link = original_link;
		this.short_link = short_link;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOriginal_link() {
		return original_link;
	}
	public void setOriginal_link(String original_link) {
		this.original_link = original_link;
	}
	public String getShort_link() {
		return short_link;
	}
	public void setShort_link(String short_link) {
		this.short_link = short_link;
	}
	
	public ShortenUrl() {
		
	}
	
	
	
	
}
