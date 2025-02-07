package com.java11_17.features;

import java.util.ArrayList;

public class A_VarJava10 {
    public static void main(String[] args) {
        var Array = new ArrayList<String>();
        Array.add("Nisarga");
        Array.add("Kunder");
        Array.add("Neha");
        Array.add("Suvarna");
        Array.add("Anush");
        Array.add("Shriyan");
        Array.forEach(System.out::println);

    }
}
