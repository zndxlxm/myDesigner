package com.csu.my.MyDesigner.behaviour;

import java.util.Observable;
import java.util.Observer;

public class NumObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        NumObservable myObserable=(NumObservable) o;     //获取被观察者对象
        System.out.println("Data has changed to " +myObserable.data);
    }
    
    public static void main(String[] args) {
        NumObserver numObserver = new NumObserver();
        NumObservable numObservable = new NumObservable();
        numObservable.addObserver(numObserver);
        
        numObservable.setData(10);
        
    }
}
