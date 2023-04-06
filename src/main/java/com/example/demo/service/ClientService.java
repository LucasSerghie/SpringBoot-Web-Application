package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Long> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(Client::getId)
                .collect(Collectors.toList());
    }

    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if (!exists)
            throw new IllegalStateException(
                    "client with id " + clientId + "does not exist");
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(Long clientId, String name, String email, String address, String gender) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException("client with id " + clientId + "does not exist"));
        if (name != null)
            client.setName(name);
        if (email != null)
            client.setEmail(email);
        if (address != null)
            client.setAddress(address);
        if (gender != null)
            client.setGender(gender);
    }

    public List<Client> getOlderThan(LocalDate date) {
        return clientRepository.olderThan(date);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }
}
