package com.team.DTO;

import java.io.Serializable;

/**
 * @Classname InitActivityInventoryDTO
 * @Description TODO
 * @Date 2021/7/17 下午4:20
 * @Created by muyi
 */
public class InitActivityInventoryDTO implements Serializable {
    private Integer activityNum;
    private Long num;

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
