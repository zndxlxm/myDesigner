package com.csu.my.MyDesigner.behaviour;

/**
 * 访问者模式
 * @author Administrator
 *
 */
public class VisitorDedigner {
    
    public static void main(String[] args) {
        Dept dept1 = new Dept("一级部门");
        dept1.setDept(dept1);
        Dept dept2 = new Dept("二级部门");
        dept1.setDept(dept2);
        Dept dept3 = new Dept("三级部门");
        dept2.setDept(dept3);    
        Dept dept4 = new Dept("四级部门");
        dept3.setDept(dept4);
        
        ListVistor listVistor = new ListVistor();
        listVistor.visit(dept1);
        
        DeleteVistor deleteVistor = new DeleteVistor();
        deleteVistor.visit(dept1);
    }
    
    /**
     * 部分类
     * @author Administrator
     *
     */
    private static class  Dept{
        
        private Dept dept;
        
        private String name;
        
        public Dept(String name) {
            this.name = name;
        }
        
        public Dept getDept() {
            return dept;
        }

        public void setDept(Dept dept) {
            this.dept = dept;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void accept(Visitor vistor) {
            vistor.visit(this);
        }
        
        @Override
        public String toString() {
            return "Dept [dept=" + dept + ", name=" + name + "]";
        }
    }
    
    /**
     * 访问者接口
     * @author Administrator
     *
     */
    private static interface Visitor{
        public void visit(Dept dept);
    }
    
    
    private static class ListVistor implements Visitor{

        @Override
        public void visit(Dept dept) {
            if(dept.getDept() != null) {
                this.visit(dept.getDept());
            }
            
            System.out.println(dept);
        }
    }
    
    
    private static class DeleteVistor implements Visitor{

        @Override
        public void visit(Dept dept) {
            if(dept.getDept() != null) {
                this.visit(dept.getDept());
            }
            
            System.out.println("从数据库删除" + dept);
        }
    }
}
