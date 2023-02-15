package com;

import java.util.Arrays;

public class Human {
    private static Human a = null;
    private int ssnId;
    private Human(int x){
        this.ssnId = x;
    }
    public static Human getI(){
        if(a==null)
            a=new Human(1);
        return a;

    }
}

 class Temp {
     public static void main(String[] args) {
         Human s=Human.getI();
//         System.out.println(s);
//         Human.a = null;
//         s=Human.getI();
//         System.out.println(s);
//         s=Human.getI();
//         System.out.println(s);
//         s=Human.getI();
//         System.out.println(s);
     }
}
