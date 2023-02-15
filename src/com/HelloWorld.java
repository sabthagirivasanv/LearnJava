package com;

import com.enums.IntSorter;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
     private int i;

    public HelloWorld() {
        System.out.println("construct");
        i = 25;
        System.out.println(25);
    }

    public HelloWorld(int i) {
        this.i = i;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("final");
        super.finalize();
    }

    //client:
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(3);

        a.sort(IntSorter.ASC_SORTER);
        a.forEach(System.out::println);

        a.sort(IntSorter.DEC_SORTER);
        a.forEach(System.out::println);

    }
}


