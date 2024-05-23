package org.example.demo.repository;

import org.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN o.customer c WHERE LOWER(c.name) = LOWER(:name)")
    List<Order> getOrdersByCustomerName(@Param("name") String name);
}
