package com.devesuperior.desafiocrudcliente.services;

import com.devesuperior.desafiocrudcliente.dto.ClientDTO;
import com.devesuperior.desafiocrudcliente.entities.Client;
import com.devesuperior.desafiocrudcliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> client = clientRepository.findAll(pageable);
        return client.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();

        entityToDTO(entity, dto);

        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }


    @PutMapping(value = "/{id}")
    public ClientDTO update(ClientDTO dto, Long id) {
        Client entity = clientRepository.getReferenceById(id);
        entityToDTO(entity, dto);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    private void entityToDTO(Client entity, ClientDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
