package br.com.zrp.teste.controller;

import br.com.zrp.teste.model.ApiResponse;
import br.com.zrp.teste.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("api")
public class PokemonController {
    @Autowired
    private PokemonService service;

    @GetMapping()
    public ResponseEntity<ApiResponse<Object>> getPokemonByName(String name) {
        ApiResponse<Object> response = new ApiResponse<>();
        try {
            Object pokemon = service.getPokemonByName(name);
            response.of(HttpStatus.OK, "Pokemon successfully found", pokemon);
        } catch (RuntimeException e) {
            response.of(HttpStatus.NOT_FOUND, "Pokemon not found with the given name");
        }
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
