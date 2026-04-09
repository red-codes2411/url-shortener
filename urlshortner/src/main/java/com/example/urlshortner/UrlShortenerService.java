package com.example.urlshortner;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UrlShortenerService {

    private final UrlMappingRepository repository;

    public UrlShortenerService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public UrlMapping createShortUrl(String originalUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(UUID.randomUUID().toString().substring(0, 6));
        return repository.save(mapping);
    }

    public UrlMapping getByShortCode(String shortCode) {
        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found: " + shortCode));
        mapping.setClickCount(mapping.getClickCount() + 1);
        return repository.save(mapping);
    }
}