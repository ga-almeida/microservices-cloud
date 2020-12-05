package com.gabrielsantos.payment.repository;

import com.gabrielsantos.payment.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
