package com.aishwarya.urlshortener;

import java.util.Optional;

import com.aishwarya.urlshortener.entities.ShortenUrl;


/**
 * This interface contains the definitions of all functions
 * required for generating Url Shortener and retrieving the
 * original URL back again.
 *
 */
public interface ShortenUrlService {
	
	public String getShortKey(long num);
	
	public long getId(String shortKey);
	
	public String getShortLink(String originalUrl);

	Optional<ShortenUrl> getShortenUrlData(String shortLink);

	long getShortKey(String shortLink);
}
