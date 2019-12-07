package com.lckgroup.canteensys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    /**
     * 订单id
     */
    @Column
    private Long orderId;
    /**
     * 所属顾客id
     */
    @Column
    private String cusId;
    /**
     * 生成时间
     */
    @Column
    private Date generTime;
    /**
     * 支付状态
     */
    @Column
    private Boolean isPaid;
    /**
     * 完成状态
     */
    @Column
    private Boolean isDone;
    /**
     * 举报状态
     */
    @Column
    private Boolean isReported;

    /**
     * 是否准备就绪
     */
    @Column
    private Boolean isReady;

    /**
     * 用餐时间
     */
    @Column
    private Date mealTime;

    public Orders() {
    }

    public Orders(Long orderId, String cusId, Date generTime, Boolean isPaid, Boolean isDone, Boolean isReported, Boolean isReady, Date mealTime) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.generTime = generTime;
        this.isPaid = isPaid;
        this.isDone = isDone;
        this.isReported = isReported;
        this.isReady = isReady;
        this.mealTime = mealTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    public Date getMealTime() {
        return mealTime;
    }

    public void setMealTime(Date mealTime) {
        this.mealTime = mealTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public Date getGenerTime() {
        return generTime;
    }

    public void setGenerTime(Date generTime) {
        this.generTime = generTime;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Boolean getReported() {
        return isReported;
    }

    public void setReported(Boolean reported) {
        isReported = reported;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", cusId='" + cusId + '\'' +
                ", generTime=" + generTime +
                ", isPaid=" + isPaid +
                ", isDone=" + isDone +
                ", isReported=" + isReported +
                ", isReady=" + isReady +
                ", mealTime=" + mealTime +
                '}';
    }
}
