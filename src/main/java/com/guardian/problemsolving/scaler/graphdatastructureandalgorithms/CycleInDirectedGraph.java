package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int A=2;
        int[][] B={{1, 2}};
        System.out.print(solve(A,B));
    }
    private static int solve(int A, int[][] B) {
        Graph graph=new Graph(A);
        Arrays.stream(B).forEach(graph::addEdge);
        return graph.hasCycle() ? 1 : 0;
    }
    private static class Graph{
        private final int nodes;
        private final List<List<Integer>> edges;
        private final boolean[] visited;
        private final boolean[] stack;

        public Graph(int nodes) {
            this.nodes=nodes;
            edges=new ArrayList<>();
            IntStream.range(0,nodes).forEach(i->edges.add(new LinkedList<>()));
            visited=new boolean[nodes];
            stack=new boolean[nodes];
        }
        public void addEdge(int[] edge){
            edges.get(edge[0]-1).add(edge[1]-1);
        }
        public boolean hasCycle(){
            for(int i=0;i<nodes;i++){
                if(hasCycle(i))
                    return true;
            }
            return false;
        }
        private boolean hasCycle(int node){
            if(stack[node])
                return true;
            if(visited[node])
                return false;

            visited[node]=true;
            stack[node]=true;
            List<Integer> children=edges.get(node);

            for(int i=0;i<children.size();i++){
                if(hasCycle(children.get(i)))
                    return true;
            }
            stack[node]=false;
            return false;
        }
    }
}
