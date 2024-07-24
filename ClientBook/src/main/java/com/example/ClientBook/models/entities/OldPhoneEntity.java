package com.example.ClientBook.models.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="old_phone")
public class OldPhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="phone")
    public String number;
    @Column(name="phonetype")
    public String typeNumber;
    @Column(name="operation")
    public String operation;
    @ManyToOne
    @JoinColumn(name="client_id")
    public ClientEntity client;
}
