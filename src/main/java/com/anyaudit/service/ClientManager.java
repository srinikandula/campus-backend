package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.payload.request.Client;
import com.anyaudit.repository.ClientRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientManager {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        com.anyaudit.models.Client c = new com.anyaudit.models.Client();
        c.setId(client.getId());
        c.setPhoneno(client.getPhoneno());
        c.setName(client.getName());
        c.setEmail(client.getEmail());
        c.setFileno(client.getFileno());
        c.setFinancialframework(client.getFinancialframework());
        clientRepository.save(c);
        return client;
    }

    public List<Client> getAllClients() {
        List<com.anyaudit.models.Client> clients = clientRepository.findAll();
        List<Client> result = new ArrayList<>();
        for (com.anyaudit.models.Client c : clients) {
            Client client = new Client();
            client.setId(c.getId());
            client.setPhoneno(client.getPhoneno());
            client.setName(c.getName());
            client.setEmail(c.getEmail());
            client.setFileno(c.getFileno());
            client.setFinancialframework(c.getFinancialframework());
            result.add(client);
        }
        return result;
    }

    public Client getClientById(Long clientId) {
        Optional<com.anyaudit.models.Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            com.anyaudit.models.Client c = optionalClient.get();
            Client client = new Client();
            client.setId(c.getId());
            client.setPhoneno(c.getPhoneno());
            client.setName(c.getName());
            client.setEmail(c.getEmail());
            client.setFileno(c.getFileno());
            client.setFinancialframework(c.getFinancialframework());
            return client;
        } else {
            return null;
        }
    }

    public Client updateClient(Long id, Client client) {
        Optional<com.anyaudit.models.Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            com.anyaudit.models.Client c = optionalClient.get();
            c.setPhoneno(client.getPhoneno());
            c.setName(client.getName());
            c.setEmail(client.getEmail());
            c.setFileno(client.getFileno());
            c.setFinancialframework(client.getFinancialframework());
            clientRepository.save(c);
            return client;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
