package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.entity.falebag;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        User result = userRepository.save(user);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size) {

        Pageable pageable= PageRequest.of(page-1,size);
        return userRepository.findAll(pageable);
    }

    @GetMapping("/findbyid/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/token") //返回账户名+密码 用于登录验证
    public List token() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<userRepository.findAll().size();i++) {
            list.add( userRepository.findAll().get(i).getName() + userRepository.findAll().get(i).getPassword());
        }
        return list;
    }

    @GetMapping("/tokenname")
    public List tokenname() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<userRepository.findAll().size();i++) {
            list.add( userRepository.findAll().get(i).getName() );
        }
        return list;
    }

    @GetMapping("/findnamebank/{username}")
    public String findbank(@PathVariable("username") String username){
        User ba = new User();
        for(int i=0; i<userRepository.findAll().size(); i++) {
            if(userRepository.findAll().get(i).getName().equals(username)){
                ba.setId(userRepository.findAll().get(i).getId());
                ba.setName(userRepository.findAll().get(i).getName());
                ba.setBankaccount(userRepository.findAll().get(i).getBankaccount());
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getBankaccount();
    }
}
