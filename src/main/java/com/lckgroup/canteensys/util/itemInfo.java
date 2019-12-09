package com.lckgroup.canteensys.util;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class itemInfo {
    /**
     * 菜id
     */
    private Long dishId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 菜名称
     */
    private  String dishName;
    /**
     * 菜数量
     */
    private Integer dishNum;
    /**
     * 条目总价
     */
    private Float dishPrice;
    /**
     * 菜评分
     */
    private Float dishStar;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishNum() {
        return dishNum;
    }

    public void setDishNum(Integer dishNum) {
        this.dishNum = dishNum;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Float getDishStar() {
        return dishStar;
    }

    public void setDishStar(Float dishStar) {
        this.dishStar = dishStar;
    }

    public itemInfo(Long dishId, Long orderId, String dishName, Integer dishNum, Float dishPrice, Float dishStar) {
        this.dishId = dishId;
        this.orderId = orderId;
        this.dishName = dishName;
        this.dishNum = dishNum;
        this.dishPrice = dishPrice;
        this.dishStar = dishStar;
    }

    public itemInfo() {
    }

    @Override
    public String toString() {
        return "itemInfo{" +
                "dishId=" + dishId +
                ", orderId=" + orderId +
                ", dishName='" + dishName + '\'' +
                ", dishNum=" + dishNum +
                ", dishPrice=" + dishPrice +
                ", dishStar=" + dishStar +
                '}';
    }
}
