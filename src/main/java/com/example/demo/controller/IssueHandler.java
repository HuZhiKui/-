package com.example.demo.controller;


import com.example.demo.entity.issue;
import com.example.demo.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/issue")
public class IssueHandler {

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping("/findAll")
    public List<issue> findAll() {
        return issueRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public issue findById(@PathVariable("id") Integer id){
        return issueRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody issue iss) {
        issue result = issueRepository.save(iss);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
    @PutMapping("/update")//修改
    public String update(@RequestBody issue iss){
            issue result = issueRepository.save(iss);
            if (result != null) {
                return "success";
            } else {
                return "error";
            }
        }

        @DeleteMapping("/deletebyid/{id}") //删除
        public void deleteById(@PathVariable("id") Integer id){
            issueRepository.deleteById(id);
        }

    @GetMapping("/tokenmes")
    public String tokenname() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<issueRepository.findAll().size();i++) {
            list.add( issueRepository.findAll().get(i).getGoodsname()+","+issueRepository.findAll().get(i).getGoodssize()+","+issueRepository.findAll().get(i).getGoodscolor()+","+issueRepository.findAll().get(i).getGoodscount());
        }
        return list.toString();
    }
}
