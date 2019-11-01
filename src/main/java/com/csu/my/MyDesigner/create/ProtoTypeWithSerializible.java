package com.csu.my.MyDesigner.create;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 采用序列化完成深度克隆
 * @author Administrator
 *
 */
public class ProtoTypeWithSerializible {
    
    public static void main(String[] args) {
        // 初始化kid
        Kid kid1 = new Kid();
        kid1.setAge(1);
        kid1.setName("大娃");
        
        ArrayList<ProtoTypeWithSerializible.Kid> kids = new ArrayList<ProtoTypeWithSerializible.Kid>();
        kids.add(kid1);
                
        // 初始化Person
        Person person1 = new Person();
        person1.setUserName("家长1");
        person1.setAge(30);
        person1.setKids(kids);
        
        System.out.println("person:" + person1);
        for(Kid kid : person1.getKids()) {
            System.out.println(kid);
        }
        
        Person personClone = BeanUtils.cloneTo(person1);
        System.out.println("克隆出来的person:" + personClone);
        Kid kid2 = new Kid();
        kid2.setAge(1);
        kid2.setName("二娃");
        personClone.getKids().add(kid2);
        
        for(Kid kid : personClone.getKids()) {
            System.out.println(kid);
        }
        
        for(Kid kid : person1.getKids()) {
            System.out.println("克隆前的数据...........");
            System.out.println(kid);
        }
        
    }
    
    
    /**
     * 孩子类
     * @author Administrator
     *
     */
    private static class Kid implements Serializable{
        
        /**
         * 1、序列化提供了一种方案，可以在JVM宕机的情况下也能够将对象保存下来，将java对象序列化成存储和传输的模式。
         * 2、虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否正确，一个非常重要的一点就是两个类的序列化编号是否一致。
         * 3、在进行反序列化的时候，JVM会把传递过来的二进制字节流中的SerialVersionUID与本地相应实体类中SerialVersionUID进行比较，
         *    如果比对一致，则认为是一致的，可以进行反序列化。
         * 4、当实现了Serializable接口的类，没有显示的声明SerialVeriionUID的时候，java序列化机制会根据编译的class自动生成一个SerialVersionUID。
         *    在这种情况下，如果class文件没有发生变化，就算在编译多次，serialVersionUID也不会有变化，但是如果发生了变化SerialVersionUID也会跟着变化
         * 5、在序列化之后，由于某些原因，我们对该类做了变更，重新启动应用后，我们相对之前序列化过的对象进行反序列化的话就会报错。
         */
        private static final long serialVersionUID = 1L;
        
        private Integer age;
        private String name;
        
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "Kid [age=" + age + ", name=" + name + "]";
        }
    }
    
    /**
     * 人类
     * 
     * @author Administrator
     *
     */
    private static class Person implements Serializable{
         
        private static final long serialVersionUID = 1L;
        
        private List<Kid> kids;
        
        private String userName;
        
        private Integer age;

        public List<Kid> getKids() {
            return kids;
        }

        public void setKids(List<Kid> kids) {
            this.kids = kids;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }

        @Override
        public String toString() {
            return "Person [kids=" + kids + ", userName=" + userName + ", age=" + age + "]";
        }
    }
    
    /**
     * 深度拷贝工具类
     * @author Administrator
     *
     */
    private static class BeanUtils{
        public static <T> T cloneTo(T t) {
            T dist = null;
            
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objOutStream = null;
            ObjectInputStream objInStream = null;
            
            try {
                objOutStream = new ObjectOutputStream(byteStream);
                objOutStream.writeObject(t);
                objOutStream.flush();
                
                objInStream = new ObjectInputStream(new ByteArrayInputStream(byteStream.toByteArray()));
                dist = (T) objInStream.readObject();
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (objInStream != null){
                try {
                    objInStream.close();
                    objInStream = null;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            
            return dist;
        }
    }
    
}
