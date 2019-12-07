package com.lckgroup.canteensys.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 条目id
     */
    @Column
    private Long itemId;
    /**
     * 订单id
     */
    @Column
    private Long orderId;
    /**
     * 菜数量
     */
    @Column
    private Integer dishNum;
    /**
     * 菜单价
     */
    @Column
    private Float dishPrice;
    /**
     * 菜评分
     */
    @Column
    private Float dishStar;

    public OrderItem() {
    }

    public OrderItem(Long itemId, Long orderId, Integer dishNum, Float dishPrice, Float dishStar) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.dishNum = dishNum;
        this.dishPrice = dishPrice;
        this.dishStar = dishStar;
    }

    @Override
    public String toString() {
        return "DishItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", orderId=" + orderId +
                ", dishNum=" + dishNum +
                ", dishPrice=" + dishPrice +
                ", dishStar=" + dishStar +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}
