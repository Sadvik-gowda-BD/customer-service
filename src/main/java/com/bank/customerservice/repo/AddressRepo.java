package com.bank.customerservice.repo;

import com.bank.customerservice.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo  extends JpaRepository<AddressEntity,Integer> {
}
