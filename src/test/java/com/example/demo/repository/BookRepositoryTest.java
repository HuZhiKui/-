package com.example.demo.repository;

import com.example.demo.entity.issue;
import com.example.demo.entity.shopcar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepositoryTest;
    @Autowired
    private ShopcarRepository shopRepositoryTest;
    @Autowired
    private IssueRepository issueRepositoryTest;
    @Test
    void findAll(){
        System.out.println(bookRepositoryTest.findAll());
  }

  @Test
    void save(){
        issue iss = new issue();
        iss.setDescc("sdjhklasd");
        iss.setRegionn("wdaas");
      iss.setGoodscolor("黑");
      iss.setGoodscount(1);
      iss.setGoodsimg("sdfjhsgkj");
      iss.setGoodsname("黑丝");
      iss.setGoodsprice(23);
      iss.setGoodssize("ghj");
      issue cai1= issueRepositoryTest.save(iss);
      System.out.println(cai1);

  }
}