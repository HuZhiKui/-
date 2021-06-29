package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.addressmessage;
import com.example.demo.repository.AddressmessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressmes")
public class AddressmessageHandler {

    @Autowired
    private AddressmessageRepository addressmesRepository;

    private List<addressmessage> list = new ArrayList<>();

    @GetMapping("/findAll") //查找
    public List<addressmessage> findAll() {
        return addressmesRepository.findAll();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<addressmessage> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size) {

        Pageable pageable= PageRequest.of(page-1,size);
        return addressmesRepository.findAll(pageable);
    }

    @GetMapping("/findbyid/{id}") //详细查找
    public addressmessage findById(@PathVariable("id") Integer id){
            return addressmesRepository.findById(id).get();
        }

    @PostMapping("/save") //保存
    public String save(@RequestBody addressmessage addmes) {
        addressmessage result = addressmesRepository.save(addmes);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @PutMapping("/update")//修改
    public String update(@RequestBody addressmessage addmes){
        addressmessage result = addressmesRepository.save(addmes);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
    @DeleteMapping("/deletebyid/{id}")//删除
    public void deleteById(@PathVariable("id") Integer id){
        addressmesRepository.deleteById(id);
    }

    @GetMapping("/tokenee")
    public List tokensee() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<addressmesRepository.findAll().size();i++) {
            list.add( addressmesRepository.findAll().get(i).getAddresssee() );
        }
        return list;
    }
}
