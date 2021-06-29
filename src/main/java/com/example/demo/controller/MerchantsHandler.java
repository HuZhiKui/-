package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.entity.falebag;
import com.example.demo.entity.merchants;
import com.example.demo.repository.MerchantsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/merch" )
public class MerchantsHandler {
    @Autowired
    private MerchantsRepository merRepository;

    @GetMapping("/findAll")
    public List<merchants> findAll() {
        return merRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody merchants mer) {
        merchants result = merRepository.save(mer);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<merchants> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size) {

        Pageable pageable= PageRequest.of(page-1,size);
        return merRepository.findAll(pageable);
    }

    @GetMapping("/findbyid/{id}")
    public merchants findById(@PathVariable("id") Integer id){
        return merRepository.findById(id).get();
    }

    @GetMapping("/token")
    public List token() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<merRepository.findAll().size();i++) {
            list.add( merRepository.findAll().get(i).getChname() + merRepository.findAll().get(i).getChpass());
        }
        return list;
    }

    @GetMapping("/findrank/{username}")
    public float findcent(@PathVariable("username") String username){
        merchants ba = new merchants();
        for(int i=0; i<merRepository.findAll().size(); i++) {
            if(merRepository.findAll().get(i).getChname().equals(username)){
                ba.setChrank(merRepository.findAll().get(i).getChrank());
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getChrank();
    }

    @GetMapping("/findstate/{username}")  //返回参数商家审核状态
    public String findstate(@PathVariable("username") String username){
        merchants ba = new merchants();
        for(int i=0; i<merRepository.findAll().size(); i++) {
            if(merRepository.findAll().get(i).getChname().equals(username)){
                ba.setChrank(merRepository.findAll().get(i).getChrank());
                ba.setState(merRepository.findAll().get(i).getState());
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getState();
    }

    @GetMapping("/tokenname") //返回商家所有名称
    public List tokenname() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<merRepository.findAll().size();i++) {
            list.add( merRepository.findAll().get(i).getChname() );
        }
        return list;
    }
    @GetMapping("/tokenstate")  //返回所有商家的状态
    public List tokenstate() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<merRepository.findAll().size();i++) {
            list.add( merRepository.findAll().get(i).getState() );
        }
        return list;
    }


}
