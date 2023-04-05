package com.anyaudit.controllers;

import com.anyaudit.payload.request.Client;
import com.anyaudit.repository.ClientRepository;
import com.anyaudit.service.ClientManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientManager clientManager;

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@Valid @RequestBody Client client) {
        clientManager.saveClient(client);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientManager.getAllClients();
        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clients);
        }
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Client client = clientManager.getClientById(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(client);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
        Client updatedClient = clientManager.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientManager.deleteClient(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }
}
