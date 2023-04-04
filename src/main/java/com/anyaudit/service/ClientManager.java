package com.anyaudit.service;

import com.anyaudit.payload.request.Client;
import com.anyaudit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientManager {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        com.anyaudit.models.Client c = new com.anyaudit.models.Client();
        c.setId(client.getId());
        c.setAddress(client.getAddress());
        c.setName(client.getName());
        clientRepository.save(c);
        return client;
    }
}
