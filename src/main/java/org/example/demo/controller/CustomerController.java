package org.example.demo.controller;

import org.example.demo.entity.Customer;
import org.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/by-city")
    public List<Customer> getCustomersByCity(@RequestParam String city) {
        return customerRepository.findByCity(city);
    }

    @GetMapping("/customers/by-age")
    public List<Customer> getCustomersByAge(@RequestParam int age) {
        return customerRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/customers/by-name-surname")
    public Optional<Customer> getCustomerByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return customerRepository.findByNameAndSurname(name, surname);
    }
}
