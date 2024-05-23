package org.example.demo.repository;

import org.example.demo.entity.Customer;
import org.example.demo.entity.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
    List<Customer> findByCity(String city);
    List<Customer> findByAgeLessThanOrderByAgeAsc(int age);
    Optional<Customer> findByNameAndSurname(String name, String surname);
}
