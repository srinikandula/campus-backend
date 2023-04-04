package com.anyaudit.controllers;

import com.anyaudit.payload.request.Client;
import com.anyaudit.service.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientManager clientManager;

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@Valid @RequestBody Client client) {
        clientManager.saveClient(client);
        return ResponseEntity.ok(client);
    }
}
