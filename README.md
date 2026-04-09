# URL Shortener

A lightweight URL shortening service built with Spring Boot.
Converts long URLs into short codes, redirects users, and tracks click counts.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- Maven

## Features
- Shorten any long URL into a 6-character code
- Redirect via short code to original URL
- Track click count per short URL
- REST API with JSON responses
- H2 console for database inspection

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/shorten?originalUrl=` | Create short URL |
| GET | `/api/{shortCode}` | Redirect to original |
| GET | `/api/stats/{shortCode}` | Get click stats |

## Running Locally

1. Clone the repo
2. Open in IntelliJ IDEA
3. Run `UrlshortnerApplication.java`
4. App starts at `http://localhost:8080`

## H2 Console
Visit `http://localhost:8080/h2-console`  
JDBC URL: `jdbc:h2:mem:urlshortener`
