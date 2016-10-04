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
public class StramException extends Exception {

    private static final long serialVersionUID = 1L;

    public StramException() {
    }

    public StramException(String message) {
        super(message);
    }

    public StramException(Throwable cause) {
        super(cause);
    }

    public StramException(String message, Throwable cause) {
        super(message, cause);
    }

}
