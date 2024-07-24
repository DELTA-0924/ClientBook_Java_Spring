package com.example.ClientBook.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Client")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;
    @Column(name="fullname")
    public String fullName;
    @Column(name="inn",unique=true,length=14)
    public String inn;
    @Column(name="date_birth")
    public Date dateOfBirth;
    @Column(name="created_date")
    @Temporal(TemporalType.DATE)
    public Date createdDate;
    @OneToMany(mappedBy = "client")
    public List<PhoneEntity> phones;
    @OneToMany(mappedBy="client")
    public List<OldPhoneEntity>oldphones;
    @PrePersist
    void onCreate(){
        createdDate=new Date();
    }
}
