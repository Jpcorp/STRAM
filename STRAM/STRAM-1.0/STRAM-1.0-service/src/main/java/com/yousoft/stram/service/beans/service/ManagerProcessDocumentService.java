/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service;

import com.yousoft.stram.exception.StramException;
import java.io.File;

/**
 *
 * @author jguinart
 */
public interface ManagerProcessDocumentService {
    
    /**
     *
     * @param file
     * @return
     * @throws StramException
     */
    public StringBuffer getProcessDocument(File file) throws StramException;
    
}
