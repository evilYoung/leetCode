package com.fourthis4.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {

    private Set<Integer> c = new HashSet<>();

    private Set<Integer> nc = new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {

            if(!sub(graph, i, new HashSet<>())){
                list.add(i);
            }
        }
        return list;
    }

    private boolean sub(int[][] graph, int point, Set<Integer> t) {
        if (c.contains(point) || t.contains(point)) {
            c.addAll(t);
            return true;
        }
        if (nc.contains(point)) {
            nc.addAll(t);
            return false;
        }

        int[] g = graph[point];
        if (g.length != 0) {
            t.add(point);
            for (int j : g) {

                boolean flag = sub(graph, j, t);
                if (!flag) {
                    t.remove(j);
                } else {
                    return true;
                }
            }
            t.remove(point);
        }
        nc.addAll(t);
        return false;
    }
}
