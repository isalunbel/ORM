package org.example.demo.repository;

import org.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public Optional<Customer> findById(String name, String surname, int age) {
        Customer customer = entityManager.find(Customer.class, new CustomerId(name, surname, age));
        return Optional.ofNullable(customer);
    }

    public List<Customer> findByCity(String city) {
        return entityManager.createQuery("SELECT c FROM Customer c WHERE c.city = :city", Customer.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Customer> findByAgeLessThanOrderByAgeAsc(int age) {
        return entityManager.createQuery("SELECT c FROM Customer c WHERE c.age < :age ORDER BY c.age ASC", Customer.class)
                .setParameter("age", age)
                .getResultList();
    }

    public Optional<Customer> findByNameAndSurname(String name, String surname) {
        List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c WHERE c.name = :name AND c.surname = :surname", Customer.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getResultList();
        return customers.isEmpty() ? Optional.empty() : Optional.of(customers.get(0));
    }

    public void delete(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
    }
}