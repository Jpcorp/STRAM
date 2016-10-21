/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.business;

import com.yousoft.stram.exception.StramViewException;

/**
 *
 * @author jguinart
 */
public interface ProcessRecoveryService {
    
    void recoveryWithEmail(String emailAccount);
}
