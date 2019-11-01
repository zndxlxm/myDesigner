package com.csu.my.MyDesigner.create;

/**
 * 单例模式
 * 1、绝对线程安全的单例模式
 * （1）double check + synchronized + volatile
 * （2）通过内部类的方式
 * 2、使用场景
 * （1）你自定义了一个框架，自定义了一份xml格式的一个配置文件，你要读取这个配置文件
 * @author Administrator
 */
public class SingletonDesignerWithDoubleCheck {
    
    // volatile的作用，防止指令重排
    private static volatile SingletonDesignerWithDoubleCheck instance = null;
    
    // SingletonDesigner已经实例化了，可能由于指令重排的原因，导致socket可能还是为null。
    private Object socket;
    
    private SingletonDesignerWithDoubleCheck() {
        
    }
    
    public static  SingletonDesignerWithDoubleCheck getInstance() {
        
        // 其中一个线程进来，发现instance为null。就会加锁
        if(instance == null) {
            // 在判断instance==null与加锁的中间，有可能其他线程已经把instance给初始化了
            synchronized (SingletonDesignerWithDoubleCheck.class) {
                // 所以此处需要再次增加一个判断，来避免 instance==null与加锁的中间，有可能其他线程已经把instance给初始化了这种情况
                if(instance == null) {
                    instance = new SingletonDesignerWithDoubleCheck();
                }
            } 
        }
        
        return instance;
    }
}
