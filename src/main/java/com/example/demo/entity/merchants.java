package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class merchants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String chname;
    private String chphone;
    private String chpass;
    private String chbanknum;
    private String chsex;
    private String chidentfynum;
    private String chbusiness;
    private String chlogo;
    private float chrank;
    private String state;

}
