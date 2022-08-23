package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CheckWhetherTheGraphIsBipartiteOrNot {
    public static void main(String[] args) {
        int A=2;
        int[][] B={{0, 1}};
        System.out.print(solve(A,B));
    }
    private static int solve(int A, int[][] B) {
        Graph graph=new Graph(A);
        Arrays.stream(B).forEach(graph::addEdge);
        return graph.isBipartite() ? 1 : 0;
    }
    private static class Graph{
        private final int nodes;
        private final List<List<Integer>> edges;
        private final boolean[] visited;
        private final int[] colors;

        public Graph(int nodes) {
            this.nodes=nodes;
            edges=new ArrayList<>();
            IntStream.range(0,nodes).forEach(i->edges.add(new LinkedList<>()));
            visited=new boolean[nodes];
            colors=new int[nodes];
        }
        public void addEdge(int[] edge){
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        public boolean isBipartite(){
            for(int i=0;i<nodes;i++){
                if(!visited[i] && !dfs(i, 1))
                    return false;
            }
            return true;
        }
        private boolean dfs(int node,int color){
            visited[node]=true;
            colors[node]=color;
            List<Integer> children=edges.get(node);

            for(int child:children){
                if((visited[child] && colors[child]==color) || (!visited[child] && !dfs(child,-color)))
                    return false;
            }
            return true;
        }
    }
}
