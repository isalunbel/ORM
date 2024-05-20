package org.example.demo.repository;

import org.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Order> getOrdersByCustomerName(String name) {
        String jpql = "SELECT o FROM Order o JOIN o.customer c WHERE LOWER(c.name) = LOWER(:name)";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}