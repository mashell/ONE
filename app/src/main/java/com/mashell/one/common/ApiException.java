package com.mashell.one.common;

/**
 * Created by mashell on 16/11/18.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ApiException extends RuntimeException {

    public ApiException(int resultCode) {
        handleErrorCode(resultCode);
    }

    private static String handleErrorCode(int code){
        String msg = null;
        switch (code){
            case 1:
                msg = "请求码是1哦";
                break;

            default:
                msg = "未知错误哦";
        }
        return msg;
    }
}
