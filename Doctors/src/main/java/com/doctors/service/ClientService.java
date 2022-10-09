package com.doctors.service;

import com.doctors.model.ClientModel;
import com.doctors.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
        return clientRepository.getAllClients();
    }

    public Optional<ClientModel> getClient(Integer id){
        return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return clientRepository.saveClient(clientModel);
    }

    public boolean deleteClient(Integer id){
        return clientRepository.deleteClient(id);
    }

    public ClientModel updateClient(ClientModel clientModel){
        return clientRepository.updateClient(clientModel);
    }

    public ClientModel save(ClientModel clientModel) {

        if (clientModel.getId() == null) {
            return clientRepository.saveClient(clientModel);
        } else {
            Optional<ClientModel> client1 = clientRepository.getClient(clientModel.getId());
            if(client1.isEmpty()) {
                return clientRepository.saveClient(clientModel);
            } else {
                return clientModel;
            }
        }
    }

    public ClientModel update(ClientModel clientModel) {
        if(clientModel.getId()!=null) {
            Optional<ClientModel>g= clientRepository.getClient(clientModel.getId());
            if(!g.isEmpty()){
                if(clientModel.getEmail()!=null){
                    g.get().setEmail(clientModel.getEmail());
                }
                if(clientModel.getPassword()!=null){
                    g.get().setPassword(clientModel.getPassword());
                }
                if(clientModel.getAge()!=null){
                    g.get().setAge(clientModel.getAge());
                }
                if(clientModel.getName()!=null){
                    g.get().setName(clientModel.getName());
                }
                return clientRepository.saveClient(g.get());
            }
        }
        return clientModel;
    }
}

