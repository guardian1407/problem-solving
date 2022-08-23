package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        merge(intervals).forEach(e->System.out.println(e.start+"->"+e.end));
    }
    private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans=new ArrayList<>();

        intervals.sort((i1, i2) -> {
            if (i1.start == i2.start && i1.end == i2.end)
                return 0;
            else if (i1.start > i2.start || (i1.start == i2.start && i1.end > i2.end))
                return 1;
            else
                return -1;
        });

        Interval prev=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval curr=intervals.get(i);
            if(prev.end<curr.start){
                ans.add(prev);
                prev=curr;
            }
            else
                prev=new Interval(Math.min(prev.start,curr.start),Math.max(prev.end,curr.end));
        }
        ans.add(prev);

        return ans;
    }
    private static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
