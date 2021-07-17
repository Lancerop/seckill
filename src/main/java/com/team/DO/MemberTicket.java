package com.team.DO;

import com.team.common.DO.MyBaseDO;

public class MemberTicket extends MyBaseDO {
    private Long memberId;
    private String useTime;
    private int status;

    public MemberTicket() {
    }

    public MemberTicket(Long memberId, String useTime, int status) {
        this.memberId = memberId;
        this.useTime = useTime;
        this.status = status;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
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
