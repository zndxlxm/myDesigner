package com.csu.my.MyDesigner.create;

/**
 * 简单工厂模式
 * 
 * @author Administrator
 *
 */
public class FactorySimple {
    
    
    private static interface Product{
        
        void operation();
    }
    
    
    private static class ProductImpl implements Product{

        @Override
        public void operation() {
            
        }
        
    }
    
    private static class SimpleFactory{
        
    }
}
