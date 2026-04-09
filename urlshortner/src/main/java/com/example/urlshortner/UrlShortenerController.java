package com.example.urlshortner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    // POST /api/shorten  → creates a short URL
    @PostMapping("/shorten")
    public ResponseEntity<UrlMapping> shorten(@RequestParam String originalUrl) {
        UrlMapping mapping = service.createShortUrl(originalUrl);
        return ResponseEntity.ok(mapping);
    }

    // GET /api/{shortCode}  → redirects to the original URL
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        UrlMapping mapping = service.getByShortCode(shortCode);
        return ResponseEntity.status(302)
                .location(URI.create(mapping.getOriginalUrl()))
                .build();
    }

    // GET /api/stats/{shortCode}  → returns click count info
    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<UrlMapping> stats(@PathVariable String shortCode) {
        UrlMapping mapping = service.getByShortCode(shortCode);
        return ResponseEntity.ok(mapping);
    }
}