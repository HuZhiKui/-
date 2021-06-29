package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.entity.manger;
import com.example.demo.repository.ManRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/man")
public class MangerHandler {
    @Autowired
    private ManRepository manRepository;

    @GetMapping("/findAll")
    public List<manger> findAll() {
        return manRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody manger user) {
        manger result = manRepository.save(user);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<manger> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size) {

        Pageable pageable= PageRequest.of(page-1,size);
        return manRepository.findAll(pageable);
    }

    @GetMapping("/findbyid/{id}")
    public manger findById(@PathVariable("id") Integer id){
        return manRepository.findById(id).get();
    }

    @GetMapping("/token")
    public List token() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<manRepository.findAll().size();i++) {
            list.add( manRepository.findAll().get(i).getManname() + manRepository.findAll().get(i).getManpass());
        }
        return list;
    }

    @GetMapping("/tokenname")
    public List tokenname() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<manRepository.findAll().size();i++) {
            list.add( manRepository.findAll().get(i).getManname() );
        }
        return list;
    }

}
