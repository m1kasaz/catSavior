package com.qin.catcat.unite.exception;

/**
 * 业务异常类
 */
// @Getter
public class BusinessException extends RuntimeException {
    private final Integer statusCode;
    
    public BusinessException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
