package com.company.tests;

import com.company.graphRepresentations.AdjacencyList;
import com.company.graphSearch.BFS;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BFSTest
{
    @Test
    public void BFSTest() {
        //creating graph
        AdjacencyList adj = new AdjacencyList(8);
        adj.addEdge(0, 1, 1);
        adj.addEdge(1, 2, 2);
        adj.addEdge(0, 3, 3);
        adj.addEdge(3, 2, 4);
        adj.addEdge(3, 4, 5);
        adj.addEdge(3, 5, 6);
        adj.addEdge(4, 6, 7);

        BFS.breadthFirstSearch(adj, 0);
    }

    @Test
    public void getPathTest()
    {
        AdjacencyList adj = new AdjacencyList(8);
        adj.addEdge(0, 1, 1);
        adj.addEdge(1, 2, 2);
        adj.addEdge(0, 3, 3);
        adj.addEdge(3, 2, 4);
        adj.addEdge(3, 4, 5);
        adj.addEdge(3, 5, 6);
        adj.addEdge(4, 6, 7);

        ArrayList<Integer> path = new ArrayList<>();

        BFS.getPath(adj,path, 0, 6);

        String pathStr = "";
        for(int v:path)
        {
            pathStr += v;
        }

        assertEquals("Shortest path 0 - 6","0346",pathStr);

        path = new ArrayList<>();

        BFS.getPath(adj,path, 0, 7);

        pathStr = "";
        for(int v:path)
        {
            pathStr += v;
        }

        assertEquals("Shortest path 0 - 7","",pathStr);
    }
}
