package com.example.ClientBook.models.entities;

import com.example.ClientBook.common.enums.TypeNumber;
import jakarta.persistence.*;
import lombok.*;
import com.example.ClientBook.models.entities.*;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clientphone")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="phone",unique = true)
    public String number;
    @Column(name="phonetype",unique = true)

    @Enumerated(EnumType.STRING)
    public TypeNumber type;
    @ManyToOne
    @JoinColumn(name="client_id")
    public ClientEntity client;

}
