package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class FirstDepthFirstSearch {
    public static void main(String[] args) {
        int[] A={1, 1, 1, 1, 1};
        final int B=1;
        final int C=1;
        System.out.print(solve(A,B,C));
    }
    private static int solve(int[] A, final int B, final int C) {
        Graph graph=new Graph(A.length);
        IntStream.range(1,A.length).forEach(i->graph.addEdge(A[i]-1,i));
        return graph.hasPath(C-1,B-1) ? 1 : 0;
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
        public void addEdge(int source,int target){
            edges.get(source).add(target);
        }
        public boolean hasPath(int source,int target){
            if(source==target)
                return true;

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
