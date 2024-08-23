package com.devesuperior.desafiocrudcliente.controller;

import com.devesuperior.desafiocrudcliente.dto.ClientDTO;
import com.devesuperior.desafiocrudcliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(Long id) {
        ClientDTO dto =clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findById(Pageable pageable) {
        Page<ClientDTO dto> =clientService
        return ResponseEntity.ok(dto);
    }
}
