package com.guardian.problemsolving.scaler.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountRectangles {
    public static void main(String[] args) {

    }
    private static int solve(int[] A, int[] B) {
        int res=0;
        Map<Integer,List<Point>> xMap=new HashMap<>();
        Map<Integer,List<Point>> yMap=new HashMap<>();
        for(int i=0;i<A.length;i++){
            int x=A[i];
            int y=B[i];
            List<Point> xList=xMap.getOrDefault(x,new ArrayList<>());
            xList.add(new Point(x,y));
            xMap.put(x,xList);
            List<Point> yList=xMap.getOrDefault(y,new ArrayList<>());
            yList.add(new Point(x,y));
            yMap.put(y,yList);
        }


        return res;
    }
    private static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
