/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjnfinal.royalrumble;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AkhilJayan
 */
public class HelperClass {

    public int MaxInput = 50;
    public int MinInput = 1;
    Map<Character, Integer> map = new HashMap<>();

    public HelperClass() {
        map.put('I', 1);
        map.put('X', 10);
        map.put('V', 5);
        map.put('L', 50);
    }

    public boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public boolean ValidateInitailInput(String str) {
        if (this.isNumeric(str)) {
            int n = Integer.parseInt(str);
            return (MinInput <= n && MaxInput >= n);
        } else {
            return false;
        }
    }

    public boolean ValidateInputName(String str) {
        List<String> strList = Arrays.asList(str.trim().split("\\s+"));
        if (strList.size() == 2) {
            String roman = strList.get(1);
            return roman.matches("[IVXL]+");
        } else {
            return false;
        }
    }

    public List<String> GetSortedList(List<String> names) {
        Map<String, Integer> output = new HashMap<>();
        List<String> sortedList = new ArrayList<>();
        names.forEach((name) -> {
            String[] strList = name.trim().split("\\s+");
            int intNumb = ConvertRomanToInt(strList[1]);
            output.put(name, intNumb);
        });

        List<Map.Entry<String, Integer>> list = new ArrayList<>(output.entrySet());
        Collections.sort(list, new ValueThenKeyComparator<>());
        list.forEach((item) -> {
            sortedList.add(item.getKey());
        });

        return sortedList;
    }

    private int ConvertRomanToInt(String roman) {
        int intNum = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int temp = map.get(roman.charAt(i));
            if (temp < prev) {
                intNum -= temp;
            } else {
                intNum += temp;
            }
            prev = temp;
        }
        return intNum;
    }

    public String ConvertIntToRoman(int input) {
        String s = "";
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
}
