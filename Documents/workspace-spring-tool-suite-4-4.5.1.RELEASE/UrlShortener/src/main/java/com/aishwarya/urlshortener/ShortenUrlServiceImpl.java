package com.aishwarya.urlshortener;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import com.aishwarya.urlshortener.repos.ShortLinkRepository;

import com.aishwarya.urlshortener.entities.ShortenUrl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation class for ShortenUrlService.
 * 
 *
 */
@Transactional
@Service
public class ShortenUrlServiceImpl implements ShortenUrlService {

	
    private static final char alphabetMap[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  


	@Value("${base.url}")
    private String BASE_URL;
	

    @Autowired
    private ShortLinkRepository shortLinkRepository;
	
	
    /** 
     * This method takes long as input and generates a
     * unique string as Short URL Key. This is computed based on 
     * converting long value to it's base 62 value. 
     */

	@Override
	public String getShortKey(long num) {
		StringBuilder shortKey = new StringBuilder();
		
		while (num > 0) {
			shortKey.append(alphabetMap[(int) (num%62)]);
			num = num / 62 ;
          }  

        return shortKey.toString();  
	}

	
	/**
	 * From the generated short key, this method is used to
	 * get back the unique identifier key in DB.
	 */
	@Override
	public long getId(String shortKey) {
		long num = 0;
		for (int i = 0; i< shortKey.length(); i++) {
			num = num * 62 + (new String(alphabetMap).indexOf(shortKey.charAt(i)));
		}

		return num;
	}

    
	/**
	 * This method inserts data into database.
	 * @param originalUrl
	 * @return
	 */

    private ShortenUrl saveEntity(String originalUrl) {
        ShortenUrl url = shortLinkRepository.save(new ShortenUrl(originalUrl));
        String shortenKey = this.getShortKey(url.getId());
        url.setShort_link(shortenKey);
        return url;
    }
	
    
    /**
     * Computes the final Short url which will be shown to 
     * the users.
     */
    @Override
	public String getShortLink(String original_link) {
		
		ShortenUrl shortenUrl = new ShortenUrl();
		if (shortLinkRepository.getShortenUrlByOriginalUrl(original_link).equals(null)) {
			shortenUrl = shortLinkRepository.getShortenUrlByOriginalUrl(original_link);
		}
		else {
			shortenUrl = saveEntity(original_link);
		}
		
		String shortLink = shortenUrl.getShort_link();
	
	
	return BASE_URL.concat(shortLink);
	
    }
    
    /**
     * From short Link, getting back the unique number.
     */
    @Override
    public long getShortKey(String shortLink) {
        long num = 0;
        for (int i = 0; i < shortLink.length(); i++) {
            num = num * 62 + (new String(alphabetMap).indexOf(shortLink.charAt(i)));
        }
        return num;
    }
    
    /**
     * Used to get the original URl from Short URl.
     * Looks for the value in data base and fetches it.
     */
    @Override
    public Optional<ShortenUrl> getShortenUrlData(String shortLink) {
        return shortLinkRepository.findById(getShortKey(shortLink));
    }
    
    
   
}
