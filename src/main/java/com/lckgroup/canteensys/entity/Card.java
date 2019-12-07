package com.lckgroup.canteensys.entity;

import javax.persistence.*;

/**
 * 一卡通
 */
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * 卡号
     */
    @Column
    private String cardId;

    /**
     * 密码
     */
    @Column
    private String cardPwd;

    /**
     * 余额
     */
    @Column
    private Float cardBalance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardPwd() {
        return cardPwd;
    }

    public void setCardPwd(String cardPwd) {
        this.cardPwd = cardPwd;
    }

    public Float getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Float cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Card() {
    }

    public Card(String cardId, String cardPwd, Float cardBalance) {
        this.cardId = cardId;
        this.cardPwd = cardPwd;
        this.cardBalance = cardBalance;
    }

    @Override
    public String toString() {
        return "card{" +
                "id=" + id +
                ", cardId='" + cardId + '\'' +
                ", cardPwd='" + cardPwd + '\'' +
                ", cardBalance=" + cardBalance +
                '}';
    }
}
