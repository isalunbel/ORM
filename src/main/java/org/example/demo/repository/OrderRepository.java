package org.example.demo.repository;

import org.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Order save(Order order) {
        if (order.getId() == null) {
            entityManager.persist(order);
        } else {
            entityManager.merge(order);
        }
        return order;
    }

    public Optional<Order> findById(Long id) {
        Order order = entityManager.find(Order.class, id);
        return order != null ? Optional.of(order) : Optional.empty();
    }

    public List<Order> findAll() {
        return entityManager.createQuery("from Order", Order.class).getResultList();
    }

    @Transactional
    public void deleteById(Long id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }
}