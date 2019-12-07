package com.lckgroup.canteensys.entity;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    /**
     * 菜id
     */
    @Column
    private Long dishId;
    /**
     * 菜名
     */
    @Column
    private String dishName;
    /**
     * 菜简介
     */
    @Column
    private String dishIntro;
    /**
     * 菜售卖窗口
     */
    @Column
    private Integer dishWindow;
    /**
     * 菜单价
     */
    @Column
    private Float dishPrice;
    /**
     * 菜图片
     */
    @Column
    private String dishPic;
    /**
     * 仓库剩余量
     */
    @Column
    private Integer remainNum;
    /**
     * 星级
     */
    @Column
    private Float starRate;
    /**
     * 已出售数
     */
    @Column
    private Integer soldNum;
    /**
     * 是否在售
     */
    @Column
    private Boolean isSelling;

    public Dish() {
    }

    public Dish(Long dishId, String dishName, String dishIntro, Integer dishWindow, Float dishPrice, String dishPic, Integer remainNum, Float starRate, Integer soldNum, Boolean isSelling) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishIntro = dishIntro;
        this.dishWindow = dishWindow;
        this.dishPrice = dishPrice;
        this.dishPic = dishPic;
        this.remainNum = remainNum;
        this.starRate = starRate;
        this.soldNum = soldNum;
        this.isSelling = isSelling;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishIntro() {
        return dishIntro;
    }

    public void setDishIntro(String dishIntro) {
        this.dishIntro = dishIntro;
    }

    public Integer getDishWindow() {
        return dishWindow;
    }

    public void setDishWindow(Integer dishWindow) {
        this.dishWindow = dishWindow;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishPic() {
        return dishPic;
    }

    public void setDishPic(String dishPic) {
        this.dishPic = dishPic;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public Float getStarRate() {
        return starRate;
    }

    public void setStarRate(Float starRate) {
        this.starRate = starRate;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Boolean getSelling() {
        return isSelling;
    }

    public void setSelling(Boolean selling) {
        isSelling = selling;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishIntro='" + dishIntro + '\'' +
                ", dishWindow=" + dishWindow +
                ", dishPrice=" + dishPrice +
                ", dishPic='" + dishPic + '\'' +
                ", remainNum=" + remainNum +
                ", starRate=" + starRate +
                ", soldNum=" + soldNum +
                ", isSelling=" + isSelling +
                '}';
    }
}
