package com.ihrm.common.exception;

import com.ihrm.common.entity.ResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 */
@Getter
@NoArgsConstructor
public class CommonException extends RuntimeException{
    private static final long serialVersionUID=1L;
    private ResultCode resultCode=ResultCode.SERVER_ERROR;
    public CommonException(ResultCode resultCode){
        this.resultCode=resultCode;
    }
}
