package com.team.DO;


import com.team.common.DO.MyBaseDO;

public class Member extends MyBaseDO {

    private String memberName;
    private String nickName;
    private int sex;
    private int status;

    public Member() {
    }

    public Member(String memberName, String nickName, int sex, int status) {
        this.memberName = memberName;
        this.nickName = nickName;
        this.sex = sex;
        this.status = status;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberName='" + memberName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                '}';
    }
}
