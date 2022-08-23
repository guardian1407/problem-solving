package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CaptureRegionsOnBoard {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'O', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'X', 'X')));

        solve(A);
        A.forEach(i->{
            i.forEach(j->System.out.print(j+" "));
            System.out.println();
        });
    }
    private static void solve(ArrayList<ArrayList<Character>> a) {
        Graph graph=new Graph(a);
        graph.captureRegions();
    }
    private static class Graph{
        private ArrayList<ArrayList<Character>> matrix;
        private int[][] visited;
        private int[] x={-1,0,0,1};
        private int[] y={0,1,-1,0};

        public Graph(ArrayList<ArrayList<Character>> matrix) {
            this.matrix=matrix;
            this.visited=new int[matrix.size()][matrix.get(0).size()];
        }
        public void captureRegions(){
            traverse();
            IntStream.range(0,matrix.size())
                    .forEach(i->
                            IntStream.range(0,matrix.get(0).size())
                                    .forEach(j->{
                                        if(matrix.get(i).get(j).equals('O') && visited[i][j]==0)
                                            matrix.get(i).set(j,'X');
                                    })
                    );
        }
        private void traverse(){
            int i=0,j=0;
            while(j<matrix.get(0).size()){
                if(matrix.get(i).get(j).equals('O') && visited[i][j]==0)
                    dfs(i,j);
                j++;
            }

            i=matrix.size()-1;j=0;
            while(j<matrix.get(0).size()){
                if(matrix.get(i).get(j).equals('O') && visited[i][j]==0)
                    dfs(i,j);
                j++;
            }

            i=0;j=0;
            while(i<matrix.size()){
                if(matrix.get(i).get(j).equals('O') && visited[i][j]==0)
                    dfs(i,j);
                i++;
            }

            i=0;j=matrix.get(0).size()-1;
            while(i<matrix.size()){
                if(matrix.get(i).get(j).equals('O') && visited[i][j]==0)
                    dfs(i,j);
                i++;
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
            return i>=0 && j>=0 && i<matrix.size() && j<matrix.get(0).size() && matrix.get(i).get(j).equals('O');
        }
    }
}
