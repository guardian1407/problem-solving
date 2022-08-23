package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.*;
import java.util.stream.IntStream;

public class PathInDirectedGraph {
    public static void main(String[] args) {
        int A=5;
        int[][] B={{1, 2},{2, 3},{3, 4},{4, 5}};
        System.out.print(solve(A,B));
    }
    private static int solve(int A, int[][] B) {
        Graph graph=new Graph(A);
        Arrays.stream(B).forEach(graph::addEdge);
        return graph.hasPath(0,A-1) ? 1 : 0;
    }
    private static class Graph{
        private final int nodes;
        private final List<List<Integer>> edges;
        private final boolean[] visited;

        public Graph(int nodes) {
            this.nodes=nodes;
            edges=new ArrayList<>();
            IntStream.range(0,nodes).forEach(i->edges.add(new LinkedList<>()));
            visited=new boolean[nodes];
        }
        public void addEdge(int[] edge){
            edges.get(edge[0]-1).add(edge[1]-1);
        }
        public boolean hasPath(int source,int target){
            Queue<Integer> bfsQueue=new LinkedList<>();
            bfsQueue.add(source);
            visited[source]=true;

            while(!bfsQueue.isEmpty()){
                int node=bfsQueue.poll();
                List<Integer> children=edges.get(node);

                for(int i=0;i<children.size();i++){
                    int child=children.get(i);
                    if(child==target)
                        return true;
                    else if(!visited[child]){
                        bfsQueue.add(child);
                        visited[child]=true;
                    }
                }
            }
            return false;
        }
    }
}
