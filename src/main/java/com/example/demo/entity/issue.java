package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String goodsname;
    private int goodscount;
    private float goodsprice;
    private String goodsimg;
    private String goodscolor;
    private String goodssize;
    private String issuetime;
    private String mername;
    private String regionn;
    private String descc;
    private String statee;
}
