package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ConstructRoads {
    public static void main(String[] args) {
        int A=2;
        int[][] B={{1, 2}};
        System.out.print(solve(A,B));
    }
    private static int solve(int A, int[][] B) {
        Graph graph=new Graph(A);
        Arrays.stream(B).forEach(graph::addEdge);
        return graph.maxRoads();
    }
    private static class Graph{
        private final int nodes;
        private final List<List<Integer>> edges;
        private final boolean[] visited;
        private long color1;
        private long color2;

        public Graph(int nodes) {
            this.nodes=nodes;
            edges=new ArrayList<>();
            IntStream.range(0,nodes).forEach(i->edges.add(new LinkedList<>()));
            visited=new boolean[nodes];
            color1=0;
            color2=0;
        }
        public void addEdge(int[] edge){
            edges.get(edge[0]-1).add(edge[1]-1);
            edges.get(edge[1]-1).add(edge[0]-1);
        }
        public int maxRoads(){
            long mod=(long)1e9+7;
            dfs(0, 1);
            long roads=((color1%mod*color2%mod)%mod-(nodes%mod-1%mod)%mod)%mod;
            roads%=mod;
            while(roads<0)
                roads+=mod;
            roads%=mod;
            return (int)roads;
        }
        private void dfs(int node,int color){
            visited[node]=true;
            List<Integer> children=edges.get(node);
            if(color==1)
                color1++;
            else
                color2++;

            for(int child:children){
                if(!visited[child])
                    dfs(child,color==1 ? 2 : 1);
            }
        }
    }
}
