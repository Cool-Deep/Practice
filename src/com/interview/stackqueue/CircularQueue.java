package com.interview.stackqueue;

class CircularQueue<T> {

    private final int QUEUE_LENGTH;
    private T data[] = null;
    private CircularQueue(int size){
        this.QUEUE_LENGTH = size;
        data = (T [])new Object[QUEUE_LENGTH];
    }
    private int top=-1;
    private int end = -1;
    void offer(T t){
        if(top == -1){
            data[0] = t;
            top =0;
            end = 0;
        }else if(top == (end + 1) % QUEUE_LENGTH){
            throw new IllegalArgumentException();
        }else{
            end = (end + 1) % QUEUE_LENGTH;
            data[end] = t;
        }
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public T top(){
//        if(top == -1){
//            throw new IllegalArgumentException();
//        }else{
//            return data[top];
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    T poll(){
        if(top == -1){
            throw new IllegalArgumentException();
        }else if(top == end){
            T t =  data[top];
            top = -1;
            end = -1;
            return t;
        }
        else{
            T t =  data[top];
            top = (top +1)% QUEUE_LENGTH;
            return t;
        }
        
    }
    boolean isEmpty(){
        return top == -1;
    }
    
    boolean isFull(){
        return top == (end + 1) % QUEUE_LENGTH;
    }
    
    public static void main(String args[]){
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
        circularQueue.offer(1);
        circularQueue.offer(2);
        circularQueue.offer(3);
        System.out.println(circularQueue.poll());
        circularQueue.offer(4);
        circularQueue.offer(5);
        System.out.print(circularQueue.isFull());
        circularQueue.offer(6);
        System.out.print(circularQueue.isFull());
    
        while(!circularQueue.isEmpty()){
            System.out.println(circularQueue.poll());
        }
    }
}
