package com.example.demo.controller;


import com.example.demo.entity.falebag;
import com.example.demo.repository.FalebagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bag")
public class FalebagHandler {
    @Autowired
    private FalebagRepository bagRepository;

    @GetMapping("/findAll")
    public List<falebag> findAll() {
        return bagRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public falebag findById(@PathVariable("id") Integer id){
        return bagRepository.findById(id).get();
    }

    @GetMapping("/findname/{username}")
        public ArrayList findfa(@PathVariable("username") String username){
        ArrayList<falebag> list1 = new ArrayList<falebag>();
        ArrayList<String> list2 = new ArrayList<String>();
            falebag ba = new falebag();
            for(int i=0; i<bagRepository.findAll().size(); i++) {
                if(bagRepository.findAll().get(i).getUsername().contains(username)){
                    ba.setCent(bagRepository.findAll().get(i).getCent());
                    ba.setId(bagRepository.findAll().get(i).getId());
                    ba.setMoney(bagRepository.findAll().get(i).getMoney());
                    ba.setUsername(bagRepository.findAll().get(i).getUsername());
                }
                else{
                    System.out.println(username);
                }
                  }
            list1.add(ba);
            return list1;
        }

    @GetMapping("/findnamemoney/{username}")
    public float findmoney(@PathVariable("username") String username){
        falebag ba = new falebag();
        for(int i=0; i<bagRepository.findAll().size(); i++) {
            if(bagRepository.findAll().get(i).getUsername().contains(username)){
                ba.setCent(bagRepository.findAll().get(i).getCent());
                ba.setId(bagRepository.findAll().get(i).getId());
                ba.setMoney(bagRepository.findAll().get(i).getMoney());
                ba.setUsername(bagRepository.findAll().get(i).getUsername());
            }
            else{
                System.out.println(username);
            }
        }
        return ba.getMoney();
    }


    @GetMapping("/findnameid/{username}")
    public int findid(@PathVariable("username") String username){
        falebag ba = new falebag();
        for(int i=0; i<bagRepository.findAll().size(); i++) {
            if(bagRepository.findAll().get(i).getUsername().equals(username)){
                ba.setCent(bagRepository.findAll().get(i).getCent());
                ba.setId(bagRepository.findAll().get(i).getId());
                ba.setMoney(bagRepository.findAll().get(i).getMoney());
                ba.setUsername(bagRepository.findAll().get(i).getUsername());
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getId();
    }

    @GetMapping("/findnamecent/{username}")
    public int findcent(@PathVariable("username") String username){
        falebag ba = new falebag();
        for(int i=0; i<bagRepository.findAll().size(); i++) {
            if(bagRepository.findAll().get(i).getUsername().equals(username)){
                ba.setCent(bagRepository.findAll().get(i).getCent());
                ba.setId(bagRepository.findAll().get(i).getId());
                ba.setMoney(bagRepository.findAll().get(i).getMoney());
                ba.setUsername(bagRepository.findAll().get(i).getUsername());
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getCent();
    }

    @PostMapping("/save")
    public String save(@RequestBody falebag bag) {
        falebag result = bagRepository.save(bag);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody falebag bag){
        falebag result = bagRepository.save(bag);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //    @PostMapping("/token")
//    public String token(@RequestBody User user){
//        User result = userRepository.save(user);
//        if(result != null){
//            return "success";
//        }
//        else{
//            return "error";
//        }
//    }
//    @GetMapping("/token")
//    public List token() {
//        List<String> list=new ArrayList<>();
//        for(int i=0;i<userRepository.findAll().size();i++) {
//            list.add( userRepository.findAll().get(i).getName() + userRepository.findAll().get(i).getPassword());
//        }
//        return list;
//    }
//    @GetMapping("/tokenname")
//    public List tokenname() {
//        List<String> list=new ArrayList<>();
//        for(int i=0;i<userRepository.findAll().size();i++) {
//            list.add( userRepository.findAll().get(i).getName() );
//        }
//        return list;
//    }
}
