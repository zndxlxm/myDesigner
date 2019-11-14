package com.csu.my.MyDesigner.create;

/**
 * 工厂方法模式 1、提供一个抽象工厂里面放创建产品所需要的公共逻辑。 2、抽象工厂的实现类里面放创建产品所需要的
 * 
 * @author Administrator
 *
 */
public class FactoryMethod {

    public static void main(String[] args) {
            Product product1 = Product1Factory.getInstance().createProduct();
            product1.show();
    }
    
    private static abstract class AbstractFactory {
        public Product createProduct() {
            System.out.println("公共逻辑");
            return PersonNalMethod();
        }

        public abstract Product PersonNalMethod();
    }
    
    private static class Product1Factory extends AbstractFactory{

        private Product1Factory() {
            
        }
        
        private static class innerClass{
            
            public static Product1Factory getInstance(){
               return new Product1Factory();
            };
        }
        
        public static Product1Factory getInstance() {
            return innerClass.getInstance();
        }
        
        @Override
        public Product PersonNalMethod() {
            System.out.println("生产产品1过程的特殊逻辑。。。。。");
            return new ProductImpl1();
        }
    }
    
    
    private static class Product2Factory extends AbstractFactory{
        @Override
        public Product PersonNalMethod() {
            // TODO Auto-generated method stub
            System.out.println("生产产品2过程的特殊逻辑。。。。。");
            return new ProductImpl2();
        }
    }
    
    private static interface Product {
       public void show();
    }
    
    private static class ProductImpl1 implements Product{
        @Override
        public void show() {
            System.out.println("产品1..show()");
        }
    }
    
    private static class ProductImpl2 implements Product{
        @Override
        public void show() {
            System.out.println("产品2..show()");
        }
    }
}

