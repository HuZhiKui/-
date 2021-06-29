package com.example.demo.repository;

import com.example.demo.entity.issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<issue,Integer> {
}
