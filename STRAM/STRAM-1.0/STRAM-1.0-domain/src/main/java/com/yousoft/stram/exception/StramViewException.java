/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.exception;

/**
 *
 * @author jguinart
 */
public class StramViewException extends Exception {

    private final int code;
    private final String reason;
    private static final long serialVersionUID = -6911104600375095766L;

    public StramViewException(String message, String reason, int code) {
        this(message, reason, code, null);
    }

    public StramViewException(String message, String reason, int code, Throwable ex) {
        super(message, ex);
        this.reason = reason;
        this.code = code;
    }

    public StramViewException(String reason, int statusCode) {
        super(reason);
        this.reason = reason;
        this.code = statusCode;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

}
