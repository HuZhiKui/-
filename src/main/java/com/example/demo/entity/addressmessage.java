package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class addressmessage {
    @Id
    private int id;
    private String addresssee;
    private int addressphone;
    private float totalmoney;
    private String addressplace;
    private String goodsmes;
    private String issure;
}
