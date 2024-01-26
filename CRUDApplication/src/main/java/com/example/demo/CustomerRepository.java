package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<Customer> findByEmail(String email);
    List<Customer> findByCityAndState(String city, String state);
    Optional<Customer> findByPhone(String phone);
    List<Customer> findByAddressContaining(String address);
    Page<Customer> findAll(Pageable pageable);

}