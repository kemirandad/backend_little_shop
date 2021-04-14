package com.accenture.tiendita.Service;

import com.accenture.tiendita.Entities.Client;
import com.accenture.tiendita.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClientService {

    @Autowired
    private ClientRepository clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("clients/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    public ResponseEntity<Object> addClient(@RequestBody Client client){
        clientService.addClient(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(client.getIdClient()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/clients/{id}")
    public void deleteByClientId(@PathVariable int id){
        Client client = clientService.deleteClient(id);
        if (client == null){
            //Pass
        }
    }
}
