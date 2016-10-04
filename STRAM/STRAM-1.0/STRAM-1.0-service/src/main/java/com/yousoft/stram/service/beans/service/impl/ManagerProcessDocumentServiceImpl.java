/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service.impl;

import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.service.beans.service.ManagerProcessDocumentService;
import java.io.File;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */
@Service
public class ManagerProcessDocumentServiceImpl implements ManagerProcessDocumentService {

    private static final Logger logger = Logger.getLogger(ManagerProcessDocumentServiceImpl.class);

    PDFParser parser;
    String parsedText;
    PDFTextStripper pdfStripper;
    PDDocument pdDoc;
    COSDocument cosDoc;
    PDDocumentInformation pdDocInfo;

    @Value("${pdf.parse.is.not.file}")
    private String IS_NOT_FILE;

    @Value("${pdf.parse.error.file}")
    private String IS_NOT_OPEN_FILE;
    
    @Value("${pdf.parse.error.file.check}")
    private String IS_NOT_PDF;

    @Override
    public StringBuffer getProcessDocument(File file) throws StramException {
        StringBuffer result = new StringBuffer();
        if (!file.isFile()) {
            throw new StramException(IS_NOT_FILE);
        }
        
        if (!checkPDF(file)) {
            throw new StramException(IS_NOT_PDF);
        }
            
        parser = openFile(file);
        
        try {
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            parsedText = pdfStripper.getText(pdDoc).trim().replaceAll("\r\n", " ");
            cosDoc.close();
            pdDoc.close();
            result.append(parsedText);
        } catch (Exception e) {
            logger.error("Error al parsear archivo : " + file.getName(), e);
            throw new StramException("Error,  get pdf to file", e);
        }

        return result;
    }

    private PDFParser openFile(File file) {
        try {
            parser = new PDFParser(new FileInputStream(file));
        } catch (Exception e) {
            logger.error(IS_NOT_OPEN_FILE, e);
        }
        return parser;
    }
    
    public boolean checkPDF(File file) {
        String fileName = file.getName().toUpperCase();
        return fileName.endsWith(".PDF");
    }


}
