package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        MyStack S=new MyStack();
        S.push(1);
        S.push(2);
        S.push(-2);
        System.out.println(S.getMin());
        S.pop();
        System.out.println(S.getMin());
        System.out.println(S.top());
    }
}
class MyStack {
    private final List<Integer> list=new ArrayList<>();
    private final List<Integer> minList=new ArrayList<>();
    private int top=-1;
    private int minTop=-1;

    public void push(int x) {
        list.add(++top,x);

        if((minTop==-1) || (x<=minList.get(minTop)))
            minList.add(++minTop,x);
    }

    public void pop() {
        if(!list.isEmpty()){
            if(list.get(top).equals(minList.get(minTop)))
                minList.remove(minTop--);
            list.remove(top--);
        }
    }

    public int top() {
        return list.isEmpty() ? top : list.get(top);
    }

    public int getMin() {
        return minList.isEmpty() ? minTop : minList.get(minTop);
    }
}
