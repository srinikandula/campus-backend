package com.anyaudit.controllers;

import com.anyaudit.models.Client;
import com.anyaudit.service.ClientManager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientManager clientService;

    @GetMapping("/list")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long clientId) {
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client saved = clientService.addClient(client);
        return ResponseEntity.created(URI.create("/clients/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long clientId, @RequestBody Client client) {
        if (client.getId() != clientId) {
            return ResponseEntity.badRequest().build();
        }
        Client saved = clientService.updateClient(client);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }

}