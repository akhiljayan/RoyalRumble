/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjnfinal.royalrumble;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author AkhilJayan
 */
public class HelperClass {
    
    public int MaxInput = 50;
    public int MinInput = 1;
    
    public boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    
    public boolean ValidateInitailInput(String str){
        if(this.isNumeric(str)){
            int n = Integer.parseInt(str);
            return (MinInput <= n && MaxInput >= n);
        }else{
            return false;
        }
    }
    
    public boolean ValidateInputName(String str){
        List<String> strList = Arrays.asList(str.trim().split("\\s+"));
        if(strList.size() == 2){
            String roman = strList.get(1);
            return roman.matches("[IVXL]+");
        }else{
            return false;
        }
    }
}
