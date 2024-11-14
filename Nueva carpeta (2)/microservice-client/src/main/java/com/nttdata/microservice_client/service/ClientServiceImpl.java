package com.nttdata.microservice_client.service;

import com.nttdata.microservice_client.model.Client;
import com.nttdata.microservice_client.model.ClientInput;
import com.nttdata.microservice_client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(ClientInput clientInput) {
        Client client = new Client();
        client.setName(clientInput.getName());
        client.setAccountType(Client.AccountTypeEnum.fromValue(clientInput.getAccountType().toString()));
        client.setDateCreation(OffsetDateTime.now());
        clientRepository.save(client);
        return client;
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClientById(Client clientInput){
        Client client = clientRepository.findById(clientInput.getId()).get();

        client.setName(clientInput.getName());
        client.setAccountType(clientInput.getAccountType());

        clientRepository.save(client);
        return client;
    }

    @Override
    public Client getClientById(String id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteClientById(String id) {
        clientRepository.deleteById(id);
    }


}
