package com.anyaudit.service;

import com.anyaudit.models.Client;
import com.anyaudit.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientControllerTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void shouldSaveClient() {
        // given
        Client client = new Client();
        client.setName("Test Client");
        client.setPhoneNo("1234567890");
        client.setEmail("test@example.com");
        client.setFileNo("123456");
        client.setFinancialFramework("Test Framework");

        // when
        Client savedClient = clientRepository.save(client);

        // then
        assertNotNull(savedClient.getId());
        assertEquals("Test Client", savedClient.getName());
        assertEquals("1234567890", savedClient.getPhoneNo());
        assertEquals("test@example.com", savedClient.getEmail());
        assertEquals("123456", savedClient.getFileNo());
        assertEquals("Test Framework", savedClient.getFinancialFramework());
    }

    @Test
    public void WhenNameIsBlank() {
        // given
        Client client = new Client();
        client.setName("");
        client.setPhoneNo("1234567890");
        client.setEmail("test@example.com");
        client.setFileNo("123456");
        client.setFinancialFramework("Test Framework");

        // when, then
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }

    @Test
    public void WhenPhoneNoIsBlank() {
        // given
        Client client = new Client();
        client.setName("Test Client");
        client.setPhoneNo("");
        client.setEmail("test@example.com");
        client.setFileNo("123456");
        client.setFinancialFramework("Test Framework");

        // when, then
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }

    @Test
    public void WhenEmailIsBlank() {
        // given
        Client client = new Client();
        client.setName("Test Client");
        client.setPhoneNo("1234567890");
        client.setEmail("");
        client.setFileNo("123456");
        client.setFinancialFramework("Test Framework");

        // when, then
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }

    @Test
    public void WhenFileNoIsBlank() {
        // given
        Client client = new Client();
        client.setName("Test Client");
        client.setPhoneNo("1234567890");
        client.setEmail("test@example.com");
        client.setFileNo("");
        client.setFinancialFramework("Test Framework");

        // when, then
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }

    @Test
    public void WhenFinancialFrameworkIsBlank() {
        // given
        Client client = new Client();
        client.setName("Test Client");
        client.setPhoneNo("1234567890");
        client.setEmail("test@example.com");
        client.setFileNo("123456");
        client.setFinancialFramework("");

        // when, then
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }


}
