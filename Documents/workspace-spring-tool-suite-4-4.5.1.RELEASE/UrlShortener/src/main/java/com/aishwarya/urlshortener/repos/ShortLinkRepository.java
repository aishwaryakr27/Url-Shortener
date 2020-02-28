package com.aishwarya.urlshortener.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aishwarya.urlshortener.entities.ShortenUrl;

/**
 * Repository class for processing Transactional data.
 * @author m016641
 *
 */
@Repository
public interface ShortLinkRepository extends JpaRepository<ShortenUrl, Long>  {
	ShortenUrl getShortenUrlByOriginalUrl(String original_link);
}

