package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] A={{1, 1, 0, 0, 0},{0, 1, 0, 0, 0},{1, 0, 0, 1, 1},{0, 0, 0, 0, 0},{1, 0, 1, 0, 1}};
        System.out.print(solve(A));
    }
    private static int solve(int[][] A) {
        Graph graph=new Graph(A);
        return graph.getIslands();
    }
    private static class Graph{
        private int[][] matrix;
        private int[][] visited;
        private int islands;
        private int[] x={-1,0,0,1,1,1,-1,-1};
        private int[] y={0,1,-1,0,1,-1,1,-1};

        public Graph(int[][] matrix) {
            this.matrix=matrix;
            this.visited=new int[matrix.length][matrix[0].length];
            this.islands =0;
        }
        public int getIslands(){
            calculateIslands();
            return this.islands;
        }
        private void calculateIslands(){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(isValidCell(i,j) && visited[i][j]==0){
                        islands++;
                        dfs(i,j);
                    }
                }
            }
        }
        private void dfs(int i,int j){
            visited[i][j]=1;
            for(int k=0;k<x.length;k++){
                if(isValidCell(i+x[k],j+y[k]) && visited[i+x[k]][j+y[k]]==0)
                    dfs(i+x[k],j+y[k]);
            }
        }
        private boolean isValidCell(int i,int j){
            return i>=0 && j>=0 && i<matrix.length && j<matrix[0].length && matrix[i][j]==1;
        }
    }
}
