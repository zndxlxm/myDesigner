package com.csu.my.MyDesigner.create;

import java.util.ArrayList;

/**
 * 原型模式
 * 
 * @author Administrator
 *
 */
public class ProtoTypeClone {
    
    
    

    private static class Student implements Cloneable {

        private int number;

        private ArrayList<String> image = new ArrayList<String>();

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        /**
         * 浅克隆
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Student stu = null;

            stu = (Student) super.clone();

            // TODO Auto-generated method stub
            stu = (Student) super.clone();
            return stu;
        }

        /**
         * 
         * @return
         */
        public Object deepClone() {
            Student stu = null;

            try {

                stu = (Student) super.clone();
                stu.image = (ArrayList<String>) this.image.clone();

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return stu;
        }
    }

}
