package com.csu.my.MyDesigner.behaviour;

public class MementoDesigner {
    
    
    private static class Editor{
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
        
        public Memento createMemento() {
            return new Memento(this.state);
        }

        public void restoreFormMemento(Memento memento) {
            this.state = memento.state;
        }
        
        @Override
        public String toString() {
            return "Editor [state=" + state + "]";
        }
    } 
    
    
    private static class Memento{
        private String state;
        
        public Memento(String state) {
            this.state = state;
        }
    }
    
    private static class Caretaker{
        private Memento memento;

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }
    
    
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setState("撤销状态");
        Caretaker caretaker = new Caretaker();  
        caretaker.setMemento(editor.createMemento());
        
        editor.setState("编辑状态");
        System.out.println(editor);
        
        editor.restoreFormMemento(caretaker.getMemento());
        
        System.out.println(editor);
    }

}
