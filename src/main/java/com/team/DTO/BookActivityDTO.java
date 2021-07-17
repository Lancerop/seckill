package com.team.DTO;

import java.io.Serializable;

/**
 * @Classname BookActivityDTO
 * @Description TODO
 * @Date 2021/7/17 下午6:38
 * @Created by muyi
 */
public class BookActivityDTO implements Serializable {
    private Long memberId;

    private Integer activityNum;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }
}
