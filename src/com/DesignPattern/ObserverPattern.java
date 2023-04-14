package com.DesignPattern;

import java.util.ArrayList;
import java.util.List;

abstract class Subject{
    List<Observer> observers = new ArrayList<>();
    void attach (Observer o){
        observers.add(o);
    }

    void detach(Observer o){
        observers.remove(o);
    }

    void notify(StateInfo st){
        observers.forEach(o -> o.update(this, st));
    }
}

class StateInfo{
    double[] values;
}

interface Observer{
    void update(Subject s, StateInfo st);
}

class TableViewObserver implements Observer{

    @Override
    public void update(Subject s, StateInfo st) {
        System.out.print("Table[");
        for (double v : st.values
        ) {
            System.out.print(v + ", ");
        }
        System.out.println("]");
    }
}

class BarChartObserver implements Observer{

    @Override
    public void update(Subject s, StateInfo st) {
        System.out.print("Bar[");
        for (double v : st.values
        ) {
            System.out.print(v + ", ");
        }
        System.out.println("]");
    }
}

class PieChartObserver implements Observer{

    @Override
    public void update(Subject s, StateInfo st) {
        System.out.print("Pie[");
        for (double v : st.values
        ) {
            System.out.print(v + ", ");
        }
        System.out.println("]");
    }
}

class LineChartObserver implements Observer{

    @Override
    public void update(Subject s, StateInfo st) {
        System.out.print("Line[");
        for (double v : st.values
        ) {
            System.out.print(v + ", ");
        }
        System.out.println("]");
    }
}

class DataSubject extends Subject{
    StateInfo st = new StateInfo();
    void setState(double[] values){
        st.values = values;
        notify(st);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DataSubject subject = new DataSubject();
        subject.attach(new TableViewObserver());
        subject.attach(new BarChartObserver());
        subject.setState(new double[]{0.2,0.2,0.3,0.3});
        subject.attach(new PieChartObserver());
        subject.attach(new LineChartObserver());
        subject.setState(new double[]{0.2,0.2,0.4,0.5});
    }
}
