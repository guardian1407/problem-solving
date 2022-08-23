package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] A={{2, 1, 1},{1, 1, 0},{0, 1, 1}};
        System.out.print(solve(A));
    }
    private static int solve(int[][] A) {
        Graph graph=new Graph(A);
        return graph.getTime();
    }
    private static class Graph{
        private int[][] matrix;
        private int[][] visited;
        private int time;
        private int[] x={-1,0,0,1};
        private int[] y={0,1,-1,0};

        public Graph(int[][] matrix) {
            this.matrix=matrix;
            this.visited=new int[matrix.length][matrix[0].length];
            this.time=0;
        }
        public int getTime(){
            calculateTime();
            return this.time;
        }
        private void calculateTime(){
            Queue<List<Integer>> bfsQueue=new LinkedList<>();
            IntStream.range(0,matrix.length)
                    .forEach(i->
                        IntStream.range(0,matrix[0].length)
                                .forEach(j->{
                                    if(matrix[i][j]==2){
                                        bfsQueue.add(Arrays.asList(i,j,0));
                                        visited[i][j]=1;
                                    }
                                })
                    );

            while(!bfsQueue.isEmpty()){
                List<Integer> node=bfsQueue.poll();
                int i=node.get(0);
                int j=node.get(1);
                int l=node.get(2);

                for(int k=0;k<x.length;k++){
                    if(isValidCell(i+x[k],j+y[k]) && visited[i+x[k]][j+y[k]]==0){
                        bfsQueue.add(Arrays.asList(i+x[k],j+y[k],l+1));
                        visited[i+x[k]][j+y[k]]=1;
                        time=Math.max(time,l+1);
                    }
                }
            }
            updateTime();
        }
        private void updateTime(){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==1 && visited[i][j]==0){
                        time=-1;
                        return;
                    }
                }
            }
        }
        private boolean isValidCell(int i,int j){
            return i>=0 && j>=0 && i<matrix.length && j<matrix[0].length && matrix[i][j]==1;
        }
    }
}
