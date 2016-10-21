/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.mvc.rest.controller.response;

import com.yousoft.stram.domain.User;

/**
 *
 * @author jguinart
 */
public class UserAutenticateResponse {
    
    private String code;
    
    private String message;           
    
    private User user;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAutenticateResponse{" + "user=" + user + '}';
    }
    
    
    
}
