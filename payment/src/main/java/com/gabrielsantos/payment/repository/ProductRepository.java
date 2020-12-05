package com.gabrielsantos.payment.repository;

import com.gabrielsantos.payment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
