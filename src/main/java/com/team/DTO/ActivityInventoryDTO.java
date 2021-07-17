package com.team.DTO;

import java.io.Serializable;

/**
 * @Classname ActivityInventoryDTO
 * @Description TODO
 * @Date 2021/7/17 下午4:02
 * @Created by muyi
 */
public class ActivityInventoryDTO implements Serializable {

    private Long numberOne;

    private Long numberTwo;

    public Long getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Long numberOne) {
        this.numberOne = numberOne;
    }

    public Long getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Long numberTwo) {
        this.numberTwo = numberTwo;
    }
}
