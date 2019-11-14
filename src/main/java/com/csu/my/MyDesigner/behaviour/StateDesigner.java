package com.csu.my.MyDesigner.behaviour;


public class StateDesigner {
     
    public static void main(String[] args) {
        
    }
    
    /**
     * 状态管理器
     * @author Administrator
     *
     */
    private static class StateManagement{
        private WaitPayOrderState waitPayOrderState = new WaitPayOrderState();
        private FinishOrderState finishOrderState = new FinishOrderState();
        
        
        
    }
    
    
    private static class OrderDTO{
        private String state;
    }
    
    /**
     * 订单状态接口
     * @author Administrator
     *
     */
    private static interface OrderState{
        
        public void transfer(OrderDTO orderDTO);
        
        public void operate(OrderDTO orderDTO);
        
        public boolean canCannelOrder();
        
    }
    
    @SuppressWarnings("unused")
    private static abstract class AbstractOrderState implements OrderState{
        public void transfer(OrderDTO orderDTO) {
            System.out.println("更新数据库状态");
        };
        
        public abstract void operate(OrderDTO orderDTO);
        
        public abstract boolean canCannelOrder();
    }
    
    /**
     * 待支付订单状态
     * @author Administrator
     *
     */
    private static class WaitPayOrderState extends AbstractOrderState{
        public void operate(OrderDTO orderDTO) {
            System.out.println("订单待支付状态");
        }
        
        public boolean canCannelOrder() {
            return true;
        }
    }
     
    /**
     * 订单完成状态
     * @author Administrator
     *
     */
    private static class FinishOrderState extends AbstractOrderState{
        public void operate(OrderDTO orderDTO) {
            System.out.println("订单待支付状态");
        }
        
        public boolean canCannelOrder() {
            return false;
        }
    }
    
    

}
