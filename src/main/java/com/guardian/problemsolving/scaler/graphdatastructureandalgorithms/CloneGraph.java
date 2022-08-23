package com.guardian.problemsolving.scaler.graphdatastructureandalgorithms;

import java.util.*;
import java.util.stream.Collectors;

//Did not consider self loop so runtime error
public class CloneGraph {
    public static void main(String[] args) {

    }
    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Graph graph=new Graph(node);
        return graph.cloneGraph();
    }
    private static class Graph{
        private final UndirectedGraphNode root;
        private Map<Integer,List<Integer>> nodeLabelMap;

        public Graph(UndirectedGraphNode root) {
            this.root = root;
            createNodeLabelMap();
        }
        private void createNodeLabelMap(){
            Queue<UndirectedGraphNode> queue=new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                UndirectedGraphNode node=queue.poll();

                if(!nodeLabelMap.containsKey(node.label)){
                    List<Integer> children=
                            node.neighbors.stream()
                                    .peek(queue::add)
                                    .map(neighbor->neighbor.label)
                                    .collect(Collectors.toList());

                    nodeLabelMap.put(node.label,children);
                }
            }
        }
        public UndirectedGraphNode cloneGraph(){
            Map<Integer,UndirectedGraphNode> map=new HashMap<>();
            Queue<UndirectedGraphNode> queue=new LinkedList<>();
            UndirectedGraphNode node=new UndirectedGraphNode(root.label);
            queue.add(node);

            while(!queue.isEmpty()){
                UndirectedGraphNode curr=queue.poll();

                if(!map.containsKey(curr.label)){
                    List<UndirectedGraphNode> neighbors=new ArrayList<>();

                    nodeLabelMap.get(curr.label)
                            .forEach(child->{
                                    UndirectedGraphNode childNode=map.containsKey(child) ? map.get(child) : new UndirectedGraphNode(child);
                                    neighbors.add(childNode);
                                    if(!map.containsKey(child))
                                        queue.add(childNode);
                            });

                    curr.neighbors=neighbors;
                    map.put(curr.label,curr);
                }
            }
            return node;
        }
    }
    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }
}
