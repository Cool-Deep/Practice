package com.interview.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

class RealTimeCounterUsingCircularQueue {

    class Node {
        long time;
        int count;
    }

    // --Commented out by Inspection (8/10/17, 5:13 PM):private static int MAX_SIZE = 0;
    private static final int MAX_BOUND = 1000;
    private int count = 0;
    // --Commented out by Inspection (8/10/17, 5:13 PM):private int currentSize = 0;

    private final Deque<Node> queue = new LinkedList<>();

    private void add(long time) {
        Node last = queue.peekLast();
        int BOUND = 100;
        if(last != null){
            if (time - last.time < BOUND) {
                last.count++;
                count++;
                return;
            } else if (time - last.time > MAX_BOUND) {
                queue.clear();
                Node n = new Node();
                n.time = time/ BOUND * BOUND;
                n.count = 1;
                queue.add(n);
                count++;
                return;
            }
        }
        while(queue.size() > 0){
            Node t1 = queue.peekFirst();
            if(time - t1.time > MAX_BOUND){
                count = count - t1.count;
                queue.pollFirst();
            }else{
                break;
            }
        }
    
        Node n = new Node();
        n.time = time/ BOUND * BOUND;
        n.count = 1;
        queue.add(n);
        count++;
    }

    private int getCount(int time){
        while(queue.size() > 0){
            Node t1 = queue.peekFirst();
            if(time - t1.time > MAX_BOUND){
                count = count - t1.count;
                queue.pollFirst();
            }else{
                break;
            }
        }
        return count;
    }
    
    public static void main(String args[]){
        RealTimeCounterUsingCircularQueue src = new RealTimeCounterUsingCircularQueue();
        src.add(10);
        src.add(70);
        src.add(80);
        src.add(120);
        src.add(150);
        src.add(450);
        src.add(750);
        src.add(799);
        src.add(1001);
        src.add(1010);
        src.add(1210);
        System.out.print(src.getCount(1515));
    }
}
