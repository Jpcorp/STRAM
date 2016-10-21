/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.busisness.impl;

import com.yousoft.stram.view.busisness.AutentificateService;
import com.yousoft.stram.domain.User;
import com.yousoft.stram.exception.StramViewException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */
@Service
public class AutentificateServiceImpl implements AutentificateService {
    
    private User user;

    @Override
    public User getAutenticateUser(String email, String passwd) throws StramViewException {
        throw new StramViewException("Not supported yet.", 300); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
