package com.example.demo.controller;

import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client")
public class  ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getClients")
    public List<Long> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @PutMapping(path = "/updateClient/{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId,
                             @RequestBody(required = false) Client client){
        clientService.updateClient(clientId, client.getName(), client.getEmail(), client.getAddress(), client.getGender());
    }

    @DeleteMapping("deleteClient/{clientId}")
    public void deleteClient(@PathVariable("clientId") Long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/filter/{date}")
    public List<Client> getOlderThan(@PathVariable ("date") String dateString){
        return clientService.getOlderThan(LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @GetMapping("/getClient/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }
}
