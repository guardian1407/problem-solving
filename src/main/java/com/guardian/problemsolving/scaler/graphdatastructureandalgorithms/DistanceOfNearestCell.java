package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class DistanceOfNearestCell {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
        A.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0)));

        solve(A).forEach(l->{
            l.forEach(e->System.out.print(e+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int[][] ans=new int[A.size()][A.get(0).size()];
        Queue<ArrayList<Integer>> queue=new LinkedList<>();
        int[][] visited=new int[A.size()][A.get(0).size()];
        int[] x={-1,0,0,1};
        int[] y={0,1,-1,0};

        for(int i=0;i<A.size();i++){
            ArrayList<Integer> row=A.get(i);
            for(int j=0;j<row.size();j++){
                if(row.get(j).equals(1)){
                    queue.add(new ArrayList<>(Arrays.asList(i,j,0)));
                    visited[i][j]=1;
                }
            }
        }

        while(!queue.isEmpty()){
            ArrayList<Integer> cell=queue.poll();
            int i=cell.get(0);
            int j=cell.get(1);
            int l=cell.get(2);
            ans[i][j]=l;
            for(int k=0;k<x.length;k++){
                if(isValidCell(i+x[k],j+y[k],A.size(),A.get(0).size()) && visited[i+x[k]][j+y[k]]==0){
                    queue.add(new ArrayList<>(Arrays.asList(i+x[k],j+y[k],l+1)));
                    visited[i+x[k]][j+y[k]]=1;
                }
            }
        }
        return Arrays.stream(ans)
                .map(arr->Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private static boolean isValidCell(int i,int j,int row,int col){
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}
