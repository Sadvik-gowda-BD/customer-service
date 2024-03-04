package com.bank.customerservice.repo;

import com.bank.customerservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {

    List<CustomerEntity> findByAge(int age);

    Optional<CustomerEntity> findByEmailId(String emailId);

    //JPQL - Fetch by using entity class
    @Query("select c from CustomerEntity c where c.emailId = ?1")
    CustomerEntity getCustomerByEmailId(String email);

    //With named param
//    @Query("select c from CustomerEntity c where c.emailId = :email")
//    CustomerEntity getCustomerByEmailId(@Param("email") String email);

    @Query("select c.name from CustomerEntity c where c.emailId = :email")
    String getCustomerNameByEmailId(@Param("email") String email);

    //Native query
    @Query(value = "select * from CUSTOMER c where c.emailId= :emailId", nativeQuery = true)
    CustomerEntity getCustomerByEmailIdNative(@Param("emailId") String email);


    @Transactional
    @Modifying
    @Query(value = "update CUSTOMER c set c.age=?3 where c.emailId= ?1 and c.name= ?2", nativeQuery = true)
    int updateCustomerAgeByEmailIdAndName(String email, String name, int age);

}
