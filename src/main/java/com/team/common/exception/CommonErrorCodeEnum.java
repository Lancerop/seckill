package com.team.common.exception;


import com.team.common.exception.BaseErrorInfoInterface;

/**
 * @Author: muyi
 * @Date: 2021/1/3 21:38
 */
public enum CommonErrorCodeEnum implements BaseErrorInfoInterface {
    /***************************************************************************************************************
     *                通用状态码                                                                               ******
     * *************************************************************************************************************/
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),


    /***************************************************************************************************************
     *                系统级别定义的异常(6位数字，99开头+4位数字（默认从0001开始）)                                  ******
     *                                      【定义开始BEGIN】                                                    ******
     * *************************************************************************************************************/
    DB_EXCEPTION("990001", "数据库异常"),
    INVALID_PARAM( "990002", "参数不合法"),
    SIGN_NOT_CORRECT( "990002", "签名校验失败"),
    TOKEN_NOT_CORRECT( "990004", "Token校验失败"),
    NO_PERMISSION( "990005", "没有权限"),
    NO_SESSION( "990006", "没有登陆"),
    UNKNOWN_EXCEPTION( "990007", "未知异常"),
    FLOW_EXCEPTION( "990008", "请求过于频繁，请稍后重试（限流了）"),
    DEGRADE_EXCEPTION("990009", "系统熔断降级，请稍后重试（熔断了）"),
    PARAMFLOW_EXCEPTION( "990010","热点限流，请稍后重试（热点限流了）"),
    AUTHORITY_EXCEPTION("990011", "授权限制了（限流了）"),
    NULL_POINTER("990012","空指针"),
    SERIALIZATION_FAIL("990013","序列化失败"),
    MQ_PRODUCT_EXCEPTION("990014","MQ生产者启动异常"),
    MQ_CONSUMER_EXCEPTION("990015","MQ消费者启动异常"),
    MQ_ONE_WAY_SEND_FAIL_EXCEPTION("990016","MQ单向消息发送异常"),
    MQ_ASNY_SEND_FAIL_EXCEPTION("990017","MQ异步消息发送异常"),
    MQ_SYNC_SEND_FAIL_EXCEPTION("990018","MQ同步消息发送异常"),
    MQ_DELAY_SEND_FAIL_EXCEPTION("990019","MQ延时消息发送异常")
    ;

    /** 错误码 */
    private String resultCode;

    /** 错误描述 */
    private String resultMsg;

    CommonErrorCodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
