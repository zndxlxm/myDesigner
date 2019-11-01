package com.csu.my.MyDesigner.create;

/**
 * 利用java虚拟机的内部原理，采用内部类保证线程绝对安全的单例模式
 * @author Administrator
 *
 */
public class SingletonDesignerWithInnerClass {
    
    private static class InnerClass{
        
        private static final SingletonDesignerWithInnerClass instance = new SingletonDesignerWithInnerClass();
        
    }
    
    public static SingletonDesignerWithInnerClass getInstance() {
        return InnerClass.instance;
    }
}
