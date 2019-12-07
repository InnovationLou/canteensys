package com.lckgroup.canteensys.entity;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    /**
     * 员工工号
     */
    @Column
    private String workId;
    /**
     * 员工类型：经理，窗口人员
     */
    @Column
    private Integer workType;

    public Worker(String workId, Integer workType) {
        this.workId = workId;
        this.workType = workType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", workId='" + workId + '\'' +
                ", workType=" + workType +
                '}';
    }
}
