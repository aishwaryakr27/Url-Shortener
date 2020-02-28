package com.aishwarya.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ShortenUrlServiceImplTest {
	 @Autowired
	 private ShortenUrlService shortenUrlService;
	 
	 @Test
	 public void getShortKeySuccess() {
	        assertEquals("c9", shortenUrlService.getShortKey(185L));
	        assertEquals("ba", shortenUrlService.getShortKey(62L));
	        assertEquals("bb", shortenUrlService.getShortKey(63L));
	        assertEquals("ca", shortenUrlService.getShortKey(124L));
	        assertEquals("cb", shortenUrlService.getShortKey(125L));

	    }
	 
	 @Test
	    public void getShortKeySuccessForMaxLong() {
	        assertEquals("k9viXaIfiWh", shortenUrlService.getShortKey(Long.MAX_VALUE));
	    }
	 
	 @Test
	 public void getShortLinkTest() {
		 assertNotNull(shortenUrlService.getShortLink("http://tiny.url"));
	 }
}







   