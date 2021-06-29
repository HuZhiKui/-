package com.example.demo.controller;


import com.example.demo.entity.shopcar;
import com.example.demo.repository.ShopcarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopcar")
public class ShopcarHandler {

    @Autowired
    private ShopcarRepository shopcarRepository;

    @GetMapping("/findAll")
    public List<shopcar> findAll() {
        return shopcarRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public shopcar findById(@PathVariable("id") Integer id){
        return shopcarRepository.findById(id).get();
    }

    @PostMapping("/save")//保存
    public String save(@RequestBody shopcar shop) {
        shopcar result = shopcarRepository.save(shop);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
    @PutMapping("/update")//修改
    public String update(@RequestBody shopcar shop){
            shopcar result = shopcarRepository.save(shop);
            if (result != null) {
                return "success";
            } else {
                return "error";
            }
        }

    @DeleteMapping("/deletebyid/{id}") //删除
    public void deleteById(@PathVariable("id") Integer id){
        shopcarRepository.deleteById(id);
        }

    @GetMapping("/tokenmes")
    public String tokenname() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<shopcarRepository.findAll().size();i++) {
            list.add( shopcarRepository.findAll().get(i).getGoodsname()+","+shopcarRepository.findAll().get(i).getGoodssize()+","+shopcarRepository.findAll().get(i).getGoodscolor()+","+shopcarRepository.findAll().get(i).getGoodscount());
        }
        return list.toString();
    }
}
