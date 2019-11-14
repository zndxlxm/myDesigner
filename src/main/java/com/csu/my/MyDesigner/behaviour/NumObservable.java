package com.csu.my.MyDesigner.behaviour;

import java.util.Observable;

/**
 * 被观察者
 * @author Administrator
 *
 */
public class NumObservable extends Observable{

    int data = 0;
    
    public void setData(int data) {
        this.data = data;
        // 通知观察者
        this.setChanged();
        this.notifyObservers();
    }
}
