package com.team.DO;

import com.team.common.DO.MyBaseDO;

public class MemberTypeDO extends MyBaseDO {
    private Long memberId;
    private String typeName;
    private int isRob;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getIsRob() {
        return isRob;
    }

    public void setIsRob(int isRob) {
        this.isRob = isRob;
    }

    @Override
    public String toString() {
        return "MemberType{" +
                "memberId=" + memberId +
                ", typeName='" + typeName + '\'' +
                ", isRob=" + isRob +
                '}';
    }
}
