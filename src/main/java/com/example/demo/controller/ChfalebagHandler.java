package com.example.demo.controller;


import com.example.demo.entity.chfalebag;
import com.example.demo.entity.falebag;
import com.example.demo.repository.ChfalebagRepository;
import com.example.demo.repository.FalebagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chbag")
public class ChfalebagHandler {
    @Autowired
    private ChfalebagRepository chbagRepository;

    @GetMapping("/findAll")
    public List<chfalebag> findAll() {
        return chbagRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public chfalebag findById(@PathVariable("id") Integer id){
        return chbagRepository.findById(id).get();
    }

    @GetMapping("/findname/{username}")
        public ArrayList findfa(@PathVariable("username") String username){
        ArrayList<chfalebag> list1 = new ArrayList<chfalebag>();
        ArrayList<String> list2 = new ArrayList<String>();
            chfalebag ba = new chfalebag();
            for(int i=0; i<chbagRepository.findAll().size(); i++) {
                if(chbagRepository.findAll().get(i).getChnamee().contains(username)){
                    ba.setChcent(chbagRepository.findAll().get(i).getChcent());
                    ba.setId(chbagRepository.findAll().get(i).getId());
                    ba.setChmoney(chbagRepository.findAll().get(i).getChmoney());
                    ba.setChnamee(chbagRepository.findAll().get(i).getChnamee());
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
        chfalebag ba = new chfalebag();
        for(int i=0; i<chbagRepository.findAll().size(); i++) {
            if(chbagRepository.findAll().get(i).getChnamee().equals(username)){
                ba.setChcent(chbagRepository.findAll().get(i).getChcent());
                ba.setId(chbagRepository.findAll().get(i).getId());
                ba.setChmoney(chbagRepository.findAll().get(i).getChmoney());
                ba.setChnamee((chbagRepository.findAll().get(i).getChnamee()));
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getChmoney();
    }

    @GetMapping("/findnameid/{username}")
    public int findid(@PathVariable("username") String username){
        chfalebag ba = new chfalebag();
        for(int i=0; i<chbagRepository.findAll().size(); i++) {
            if(chbagRepository.findAll().get(i).getChnamee().equals(username)){
                ba.setChcent(chbagRepository.findAll().get(i).getChcent());
                ba.setId(chbagRepository.findAll().get(i).getId());
                ba.setChmoney(chbagRepository.findAll().get(i).getChmoney());
                ba.setChnamee((chbagRepository.findAll().get(i).getChnamee()));
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
    public float findcent(@PathVariable("username") String username){
        chfalebag ba = new chfalebag();
        for(int i=0; i<chbagRepository.findAll().size(); i++) {
            if(chbagRepository.findAll().get(i).getChnamee().equals(username)){
                ba.setChcent(chbagRepository.findAll().get(i).getChcent());
                ba.setId(chbagRepository.findAll().get(i).getId());
                ba.setChmoney(chbagRepository.findAll().get(i).getChmoney());
                ba.setChnamee((chbagRepository.findAll().get(i).getChnamee()));
                System.out.println("success");
                break;
            }
            else{
                System.out.println(username+"第"+(i+1)+"次");
                continue;
            }
        }
        return ba.getChcent();
    }

    @PostMapping("/save")
    public String save(@RequestBody chfalebag bag) {
        chfalebag result = chbagRepository.save(bag);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody chfalebag bag){
        chfalebag result = chbagRepository.save(bag);
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
