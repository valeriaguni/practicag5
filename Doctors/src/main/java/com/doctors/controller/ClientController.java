package com.doctors.controller;

import com.doctors.model.ClientModel;
import com.doctors.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> getClient(@PathVariable Integer id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable Integer id){
        return clientService.deleteClient(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel updateClient(@RequestBody ClientModel clientModel){
        return clientService.updateClient(clientModel);
    }

}
