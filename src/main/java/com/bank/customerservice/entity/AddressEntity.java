package com.bank.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private int addressId;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String Country;

    //Bi directional
    @OneToOne(mappedBy = "addressEntity")
    @JsonIgnore
    private CustomerEntity customerEntity;

}
