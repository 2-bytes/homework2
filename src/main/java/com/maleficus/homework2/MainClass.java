/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maleficus.homework2;

import com.maleficus.homework2.task8.ListImpl;

/**
 *
 * @author Peter Schwarz
 */
public class MainClass {

    public static void main(String[] args){

        ListImpl<Integer> sampleList = new ListImpl<Integer>(){{
            put(0);
            put(1);
            put(2);
            put(3);
            put(4);
            put(5);
        }};
    }
}
