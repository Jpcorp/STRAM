/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.busisness;

import com.yousoft.stram.domain.User;
import com.yousoft.stram.exception.StramViewException;

/**
 *
 * @author jguinart
 */
public interface AutentificateService {
    
    public User getAutenticateUser(String email, String passwd) throws StramViewException;
    
    
}
