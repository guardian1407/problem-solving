package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String[] args){
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        Interval newInterval=new Interval(2,5);

        insert(intervals,newInterval).forEach(i->System.out.println(i.start+"->"+i.end));
    }
    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
        ArrayList<Interval> ans=new ArrayList<>();

        for(int i=0;i<intervals.size();i++){
            Interval curr=intervals.get(i);
            if(newInterval.end<curr.start){
                ans.add(newInterval);
                newInterval=curr;
            }
            else if(newInterval.start>curr.end)
                ans.add(curr);
            else
                newInterval=new Interval(Math.min(newInterval.start,curr.start),Math.max(newInterval.end,curr.end));
        }
        ans.add(newInterval);
        return ans;
    }
    private static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}

