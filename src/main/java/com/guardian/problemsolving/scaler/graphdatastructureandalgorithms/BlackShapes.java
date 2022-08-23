package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

public class BlackShapes {
    public static void main(String[] args) {
        String[] A={};
        System.out.print(black(A));
    }
    private static int black(String[] A) {
        int[][] matrix=new int[A.length][A[0].length()];
        for(int i=0;i<A.length;i++){
            String row=A[i];
            for(int j=0;j<row.length();j++){
                if(row.charAt(j)=='X')
                    matrix[i][j]=1;
            }
        }
        Graph graph=new Graph(matrix);
        return graph.getBlackShapesCount();
    }
    private static class Graph{
        private int[][] matrix;
        private int[][] visited;
        private int[] x={-1,0,0,1};
        private int[] y={0,1,-1,0};

        public Graph(int[][] matrix) {
            this.matrix=matrix;
            this.visited=new int[matrix.length][matrix[0].length];
        }
        public int getBlackShapesCount(){
            int count=0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(isValidCell(i,j) && visited[i][j]==0){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            return count;
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
