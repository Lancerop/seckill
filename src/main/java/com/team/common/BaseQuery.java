package com.team.common;

import com.team.common.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import com.team.common.exception.CommonErrorCodeEnum;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @Author: muyi
 * @Date: 2021/1/3 21:19
 */
public class BaseQuery extends MyPage implements Serializable {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    private String column;
    private String sort;

    public BaseQuery() {
    }

    public String getColumn() {
        if (StringUtils.isEmpty(this.column)) {
            return this.column;
        } else {
            Field[] fields = this.getClass().getDeclaredFields();
            Field[] parentFields = this.getClass().getSuperclass().getDeclaredFields();
            this.column = StringUtils.upperCase(this.column);
            boolean b = Stream.concat(Stream.of(fields), Stream.of(parentFields)).map((d) -> {
                return (String)Stream.of(d.getName().split("")).map((s) -> {
                    return Character.isUpperCase(s.charAt(0)) ? "_" + s.toLowerCase() : s;
                }).reduce(String::concat).get();
            }).anyMatch((f) -> {
                return f.toUpperCase().equals(this.column);
            });
            if (!b) {
                throw new MyException(CommonErrorCodeEnum.INVALID_PARAM.getResultCode(), "排序字段必须为该表对应对象字段");
            } else {
                return this.column;
            }
        }
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSort() {
        if (StringUtils.isEmpty(this.sort)) {
            return this.sort;
        } else {
            this.sort = StringUtils.upperCase(this.sort);
            return this.sort;
        }
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
