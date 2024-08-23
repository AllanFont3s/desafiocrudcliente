package com.devesuperior.desafiocrudcliente.services;

import com.devesuperior.desafiocrudcliente.dto.ClientDTO;
import com.devesuperior.desafiocrudcliente.entities.Client;
import com.devesuperior.desafiocrudcliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    public Page<ClientDTO> findByAll(Pageable peageable){
        Page<Client> client = clientRepository.findAll(peageable);
        return client.map(x-> new ClientDTO(x));
    }


}
