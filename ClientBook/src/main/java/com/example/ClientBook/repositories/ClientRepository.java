package com.example.ClientBook.repositories;

import com.example.ClientBook.models.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository  extends JpaRepository<ClientEntity, Long> {
    public Optional<ClientEntity> findByInn(String inn);
    public Optional<ClientEntity> deleteByInn(String inn);
}
