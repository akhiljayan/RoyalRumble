/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjnfinal.royalrumble;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author AkhilJayan
 * @param <K>
 * @param <V>
 */
public class ValueThenKeyComparator <K extends Comparable<? super K>, V extends Comparable<? super V>>
    implements Comparator<Map.Entry<K, V>> {

    @Override
    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
        String[] name1 = a.getKey().toString().split("\\s+");
        String[] name2 = b.getKey().toString().split("\\s+");
        int cmp1 = name1[0].compareTo(name2[0]);
        if (cmp1 != 0) {
            return cmp1;
        } else {
            return a.getValue().compareTo(b.getValue());
        }
    }

}
