package com.team.DO;

import com.team.common.DO.MyBaseDO;

import java.util.Date;

public class MemberTicketDO extends MyBaseDO {
    private Long memberId;
    private Date useTime;
    private int status;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MemberTicket{" +
                "memberId=" + memberId +
                ", useTime='" + useTime + '\'' +
                ", status=" + status +
                '}';
    }
}
