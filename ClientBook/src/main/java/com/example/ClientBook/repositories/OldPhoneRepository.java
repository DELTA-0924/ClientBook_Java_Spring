package com.example.ClientBook.repositories;

import com.example.ClientBook.models.entities.OldPhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldPhoneRepository extends JpaRepository <OldPhoneEntity,Long>{
}
