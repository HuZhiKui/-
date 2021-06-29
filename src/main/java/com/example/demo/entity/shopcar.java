package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class shopcar {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String goodsname;
    private int goodscount;
    private float goodsprice;
    private String goodsimg;
    private String goodscolor;
    private String goodssize;

}
