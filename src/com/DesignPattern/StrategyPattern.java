package com.DesignPattern;

import java.util.Arrays;
import java.util.List;

class Context {
    SortStrategy strategy;
    double[] values;
    Context(SortStrategy strategy)
    {
        this.strategy = strategy;
    }

    void sortByStrategy(Double[] values){
        strategy.sort(Arrays.asList(values));
    }
}

abstract class SortStrategy{
    abstract void sort(List<Double> context);
}

class BubbleSort extends  SortStrategy {

    @Override
    void sort(List<Double> values) {
        System.out.println("Bubble sorting " + values);
    }
}

class MergeSort extends  SortStrategy {
    @Override
    void sort(List<Double> values) {
        System.out.println("MergeSort sorting " + values);
    }
}

class DataProcessor
{
    public void process(Context c1, Double[] values){
        System.out.println("do something before sorting");
        c1.sortByStrategy(values);
        System.out.println("do something after sorting");
    }
}


public class StrategyPattern {
    public static void main(String[] args) {
        Context c1 = new Context(new BubbleSort());
        Double[] value1 = {0.1, 0.2, 0.3};
//        c1.sortByStrategy(value1);
        Double[] value2 = {0.4, 0.5, 0.6};
//        c1.sortByStrategy(value2);
        Context c2 = new Context(new MergeSort());
//        c2.sortByStrategy(value1);

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.process(c1,value1);
        dataProcessor.process(c2,value2);
    }
}
