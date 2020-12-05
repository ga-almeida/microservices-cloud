package com.gabrielsantos.payment.repository;

import com.gabrielsantos.payment.entity.SellProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellProductRepository extends JpaRepository<SellProduct, Long> {
}
