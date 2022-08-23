package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.*;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(1, 7)));
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(1, 7)));
        A.add(new ArrayList<>(Arrays.asList(1, 4)));
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        solve(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A){
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer, Integer> freqHm=new HashMap<>();
        Map<Integer, Stack<Integer>> hm=new HashMap<>();
        int maxFreq=0;

        for(int i=0;i<A.size();i++){
            int op=A.get(i).get(0);

            if(op==1){
                int ele=A.get(i).get(1);
                int freq=freqHm.containsKey(ele) ? freqHm.get(ele)+1 : 1;
                freqHm.put(ele,freq);
                maxFreq=Math.max(maxFreq,freq);

                Stack<Integer> freqStack=hm.containsKey(freq) ? hm.get(freq) : new Stack<>();
                freqStack.push(ele);
                hm.put(freq,freqStack);
                ans.add(-1);
            }
            else{
                Stack<Integer> maxStack=hm.get(maxFreq);
                int ele=maxStack.pop();
                int freq=freqHm.get(ele)-1;

                if(freq==0)
                    freqHm.remove(ele);
                else
                    freqHm.put(ele,freq);

                if(maxStack.isEmpty())
                    hm.remove(maxFreq--);
                ans.add(ele);
            }
        }
        return ans;
    }
}
