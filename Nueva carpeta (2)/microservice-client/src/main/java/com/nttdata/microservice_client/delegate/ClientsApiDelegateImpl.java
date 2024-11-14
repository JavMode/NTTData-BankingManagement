package com.nttdata.microservice_client.delegate;

import com.nttdata.microservice_client.api.ClientsApiDelegate;
import com.nttdata.microservice_client.model.Client;
import com.nttdata.microservice_client.model.ClientInput;
import com.nttdata.microservice_client.service.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsApiDelegateImpl implements ClientsApiDelegate {

    private final ClientServiceImpl clientService;

    public ClientsApiDelegateImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Client> createClient(ClientInput clientInput) {
        return ResponseEntity.ok(clientService.createClient(clientInput));
    }

    @Override
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @Override
    public ResponseEntity<Void> deleteClientById(String id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Client> getClientById(String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @Override
    public ResponseEntity<Client> updateClient(Client client) {
        return ResponseEntity.ok(clientService.updateClientById(client));
    }
}
