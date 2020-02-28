package com.aishwarya.urlshortener.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import com.aishwarya.urlshortener.ShortenUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to redirect to the Original Url.
 * 
 */
@Controller
@RequestMapping("/urlshortener")
public class RedirectUrlController {

	@Autowired
	private ShortenUrlService shortenUrlService;
	

    @GetMapping("/{shortLink}")
    public ModelAndView redirectToOriginalUrl(@PathVariable("shortLink") String shortLink) {
        return shortenUrlService.getShortenUrlData(shortLink)
                .map(shortenUrl -> new ModelAndView("redirect:" + shortenUrl.getOriginal_link()))
                .orElseGet(() -> new ModelAndView("Short Link not found"));
    }

}
