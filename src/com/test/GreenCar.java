package com.test;

import com.HelloWorld;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class GreenCar extends HelloWorld {

    static {
        System.out.println("static method");
    }

    {
        System.out.println("init block");
    }
    private int a = 0;

    public GreenCar(int a) {
        super();
        System.out.println("green const");
        this.a = a;
    }

    public static void main(String[] args) {
        GreenCar g = new GreenCar(1);
        GreenCar g1 = new GreenCar(2);

        Function<Integer, String> math = (Integer a) -> a + "";
        math = math.andThen(a -> a +"_"+ a);
        System.out.println(math.apply(1));

    }
}
