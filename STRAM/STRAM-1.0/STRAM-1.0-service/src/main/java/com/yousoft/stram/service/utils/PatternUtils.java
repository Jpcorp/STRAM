/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jguinart
 */
public class PatternUtils {

    static Pattern patron;

    static Matcher encaja;

    String expression;

    public PatternUtils(String exp) {
        this.expression = exp;
    }

    /**
     * Metodo obtiene un patron desde una properties
     *
     * @param value cadena a evaluar
     * @param expression patron
     * @return String
     */
    public static Matcher getPatternWithAll(String value, String expression) {
        patron = Pattern.compile(expression);
        encaja = patron.matcher(value);
        return encaja;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
