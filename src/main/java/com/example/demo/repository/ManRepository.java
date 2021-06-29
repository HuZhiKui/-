package com.example.demo.repository;

import com.example.demo.entity.issue;
import com.example.demo.entity.manger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRepository extends JpaRepository<manger,Integer> {
}
