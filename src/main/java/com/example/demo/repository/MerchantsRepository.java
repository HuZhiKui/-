package com.example.demo.repository;

import com.example.demo.entity.merchants;
import com.example.demo.entity.shopcar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantsRepository extends JpaRepository<merchants,Integer> {
}
