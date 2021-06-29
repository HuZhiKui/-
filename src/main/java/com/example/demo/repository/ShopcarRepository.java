package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.shopcar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopcarRepository extends JpaRepository<shopcar,Integer> {
}
