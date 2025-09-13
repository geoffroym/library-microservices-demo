package org.library.orders.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookClient {

    private final String baseUrl;
    private final RestTemplate restTemplate;

    public BookClient(RestTemplateBuilder builder) {
        this.baseUrl = "http://localhost:8000/api/books";
        this.restTemplate = builder.build();
    }

    public String getBookById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, String.class);
    }

    public List<String> getAllBooks() {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {}
        );
        return response.getBody();
    }

    public boolean decreaseStock(Long id) {
        ResponseEntity<Void> response = restTemplate.exchange(
                baseUrl + "/" + id + "/decrease-stock",
                HttpMethod.PUT,
                null,
                Void.class
        );
        return response.getStatusCode().is2xxSuccessful();
    }
}
