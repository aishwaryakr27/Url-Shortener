package com.aishwarya.urlshortener.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aishwarya.urlshortener.dto.OriginalUrlDTO;
import com.aishwarya.urlshortener.dto.ShortLinkDTO;
import com.aishwarya.urlshortener.ShortenUrlService;


/**
 * Rest Controller as the starting point for users to 
 * enter Original Url and get the url shortener back.
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UrlShortenerController {

	@Autowired
	private ShortenUrlService shortenUrlService;
	
	@PostMapping("/urlshortener")
	public ResponseEntity<ShortLinkDTO> urlShortner(@Validated @RequestBody OriginalUrlDTO originalUrlDto) {
	
		return ResponseEntity.ok(new ShortLinkDTO(shortenUrlService.getShortLink(originalUrlDto.getOriginalUrl())));
}




}
