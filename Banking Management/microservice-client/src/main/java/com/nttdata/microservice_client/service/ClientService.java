package com.nttdata.microservice_client.service;

import com.nttdata.microservice_client.model.Client;
import com.nttdata.microservice_client.model.ClientInput;

import java.util.List;

public interface ClientService {

    Client createClient(ClientInput clientInput);

    List<Client> getClients();

    Client updateClientById(Client client);

    Client getClientById(String id);

    void deleteClientById(String id);

}
