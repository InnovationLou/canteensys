package com.lckgroup.canteensys.entity;

import javax.persistence.*;

/**
 * 顾客
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String cusId;

    @Column
    private String cusPwd;

    @Column
    private Float cusBalance;

    public Customer() {
    }

    public Customer(String cusId, String cusPwd, Float cusBalance) {
        this.cusId = cusId;
        this.cusPwd = cusPwd;
        this.cusBalance = cusBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusPwd() {
        return cusPwd;
    }

    public void setCusPwd(String cusPwd) {
        this.cusPwd = cusPwd;
    }

    public Float getCusBalance() {
        return cusBalance;
    }

    public void setCusBalance(Float cusBalance) {
        this.cusBalance = cusBalance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cusId='" + cusId + '\'' +
                ", cusPwd='" + cusPwd + '\'' +
                ", cusBalance=" + cusBalance +
                '}';
    }
}
