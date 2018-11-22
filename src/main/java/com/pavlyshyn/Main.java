package com.pavlyshyn;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction <Integer, Integer, String> stringBiFunction = (a,b)->{ return a.toString()+b.toString();};
        System.out.println(stringBiFunction.apply(1,2));
    }
}
