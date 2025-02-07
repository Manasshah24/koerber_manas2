package com.java9.features;

import java.util.List;

public class J_StreamAPIEnhancements {
    public static void main(String[] args) {
        System.out.println("takewhile");
        List<Integer > list=List.of(4,6,8,9,50);

        list.stream().takeWhile(n->n%2==0).forEach(n-> System.out.println(n));

    }
}
