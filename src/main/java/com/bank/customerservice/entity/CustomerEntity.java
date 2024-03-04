package com.bank.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {


    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence")
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Column(name = "NAME")
    private String name;
    //@Column(name = "EMAIL_ID", unique = true, nullable = true)
    private String emailId;
    @Column(name = "GENDER")
    private char gender;
    @Column(name = "AGE")
    private Integer age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_IdFk", referencedColumnName = "ADDRESS_ID")
    @JsonIgnore
    private AddressEntity addressEntity;

    /* or
    @Column(name = "address_IdFk")
    private addressId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_IdFk", insertable=false, updatable=false)
    @JsonIgnore
    private AddressEntity addressEntity;

    */


}
