/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjnfinal.royalrumble;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AkhilJayan
 */
public class RoyalRumble {

    static Console console = System.console();
    static Scanner in = new Scanner(System.in);
    static HelperClass helper = new HelperClass();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = GetInputNumber();
        List<String> names = GetInputNames(n);
        List<String> result = helper.GetSortedList(names);
        PrintOutput(result);
    }

    public static int GetInputNumber() {
        System.out.print("Number of Names: ");
        String s = in.nextLine();
        if (helper.ValidateInitailInput(s)) {
            return Integer.parseInt(s);
        } else {
            System.out.print("ERROR!! Please enter a valid number \n");
            return GetInputNumber();
        }
    }

    public static List<String> GetInputNames(int n) {
        List<String> names = new ArrayList<>();
        System.out.println("\nEnter the names?\n");
        boolean valid;
        int count = 0;
        do {
            System.out.print((count+1)+": ");
            String s = in.nextLine();
            if (!helper.ValidateInputName(s)) {    
                System.out.println("ERROR!! Please enter a valid name");
            }else{
                names.add(s);
                count++;
            }
        } while (!(count == n));
        return names;
    }
    
    public static void PrintOutput(List<String> result){
        System.out.println("\n");
        System.out.println("=====Sorted List=====");
        for(int i=0; i<result.size(); i++){
            System.out.println( (i+1) + ": " + result.get(i)); 
        }
    }

}
