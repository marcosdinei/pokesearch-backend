package br.com.zrp.teste.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {
    public Object getPokemonByName(String name) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
