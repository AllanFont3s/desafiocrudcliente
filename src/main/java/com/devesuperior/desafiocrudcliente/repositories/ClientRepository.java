package com.devesuperior.desafiocrudcliente.repositories;

import com.devesuperior.desafiocrudcliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
