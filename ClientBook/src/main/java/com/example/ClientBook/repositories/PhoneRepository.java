package com.example.ClientBook.repositories;

import com.example.ClientBook.models.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<PhoneEntity,Long> {

}
