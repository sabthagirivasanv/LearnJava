package com.enums;

import java.util.Comparator;

public enum IntSorter implements Comparator<Integer> {
    ASC_SORTER(){
        @Override
        public int compare(Integer o1,Integer o2) {
            return o1 - o2;
        }
    }, DEC_SORTER(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
}
