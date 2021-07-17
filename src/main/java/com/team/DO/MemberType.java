package com.team.DO;

import com.team.common.DO.MyBaseDO;

public class MemberType extends MyBaseDO {
    private Long memberID;
    private String typeName;
    private int isRob;

    public MemberType() {
    }

    public MemberType(Long memberID, String typeName, int isRob) {
        this.memberID = memberID;
        this.typeName = typeName;
        this.isRob = isRob;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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
                "memberID=" + memberID +
                ", typeName='" + typeName + '\'' +
                ", isRob=" + isRob +
                '}';
    }
}
