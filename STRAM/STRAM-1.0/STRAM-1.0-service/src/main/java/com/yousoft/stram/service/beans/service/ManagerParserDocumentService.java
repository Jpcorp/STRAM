/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service;

import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;

/**
 *
 * @author jguinart
 */
public interface ManagerParserDocumentService {
    
    public void processDocumentCav(StringBuffer input);
    
    public Vehicule getParseDocument(StringBuffer input) throws StramException;
}
