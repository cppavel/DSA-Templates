package com.company.tests;

import com.company.graphBasics.Edge;
import com.company.graphRepresentations.AdjacencyMatrix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacencyMatrixTest
{
    @Test
    public void adjacencyMatrixInitialization()
    {
        AdjacencyMatrix adj = new AdjacencyMatrix(4);
        adj.addEdge(0,1,2);
        adj.addEdge(1,2,42);
        adj.addEdge(2,3,-1);
        adj.addEdge(3,0,25);
        adj.addEdge(0,2,1);


        boolean expected = true;

        boolean actual = adj.edgeExists(0,1);
        assertEquals("Edge 0 - 1",expected,actual);

        actual = adj.edgeExists(1,2);
        assertEquals("Edge 1 - 2",expected,actual);

        actual = adj.edgeExists(2,3);
        assertEquals("Edge 2 - 3",expected,actual);

        actual = adj.edgeExists(3,0);
        assertEquals("Edge 3 - 0",expected,actual);


        actual = adj.edgeExists(0,2);
        assertEquals("Edge 0 - 2",expected,actual);

        expected = false;

        actual = adj.edgeExists(2,0);
        assertEquals("Edge 2 - 0",expected,actual);

        actual = adj.edgeExists(1,3);
        assertEquals("Edge 1 - 3",expected,actual);
    }

    @Test
    public void removingEdge()
    {
        AdjacencyMatrix adj = new AdjacencyMatrix(4);
        adj.addEdge(0,1,2);
        adj.addEdge(1,2,42);
        adj.addEdge(2,3,-1);
        adj.addEdge(3,0,25);
        adj.addEdge(0,2,1);

        boolean expected = true;
        boolean actual = adj.edgeExists(0,1);
        assertEquals("Edge 0 - 1",expected,actual);

        adj.removeEdge(0,1);

        expected = false;
        actual = adj.edgeExists(0,1);
        assertEquals("0-1 was removed",expected,actual);

    }

    @Test
    public void getEdge()
    {
        AdjacencyMatrix adj = new AdjacencyMatrix(4);
        adj.addEdge(0,1,2);
        adj.addEdge(1,2,42);
        adj.addEdge(2,3,-1);
        adj.addEdge(3,0,25);
        adj.addEdge(0,2,1);

        Edge e = adj.getEdge(2,3);

        int expected= -1;
        int actual = e.getEdge().get(2);

        assertEquals("Weight - 1",expected,actual);
    }



}
