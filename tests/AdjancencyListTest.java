package com.company.tests;

import com.company.representations.AdjacencyList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjancencyListTest
{
    @Test
    public void adjacencyListInitialization()
    {
        AdjacencyList adj = new AdjacencyList(7);
        adj.addEdge(0,1,1);
        adj.addEdge(1,2,2);
        adj.addEdge(0,3,3);
        adj.addEdge(3,2,4);
        adj.addEdge(3,4,5);
        adj.addEdge(3,5,6);
        adj.addEdge(4,6,7);

        boolean expected = true;

        boolean actual = adj.edgeExists(0,1);
        assertEquals("Edge 0 - 1",expected,actual);

        actual = adj.edgeExists(1,2);
        assertEquals("Edge 1 - 2", expected,actual);

        actual = adj.edgeExists(0,3);
        assertEquals("Edge 0 - 3", expected, actual);

        actual = adj.edgeExists(3,2);
        assertEquals("Edge 3- 2",expected,actual);

        actual = adj.edgeExists(3,4);
        assertEquals("Edge 3 - 4",expected, actual);

        actual = adj.edgeExists(3,5);
        assertEquals("Edge 3 - 5", expected, actual);

        actual = adj.edgeExists(4,6);
        assertEquals("Edge 4 - 6",expected,actual);

        expected = false;

        actual = adj.edgeExists(6,4);
        assertEquals("No Edge 6 - 4",expected,actual);

        actual = adj.edgeExists(0,6);
        assertEquals("No Edge 6 - 4",expected, actual);
    }

    @Test
    public void removingEdge()
    {
        AdjacencyList adj = new AdjacencyList(7);
        adj.addEdge(0,1,1);
        adj.addEdge(1,2,2);
        adj.addEdge(0,3,3);
        adj.addEdge(3,2,4);
        adj.addEdge(3,4,5);
        adj.addEdge(3,5,6);
        adj.addEdge(4,6,7);

        boolean expected = true;
        boolean actual = adj.edgeExists(0,1);
        assertEquals("Edge 0 - 1",expected,actual);

        adj.removeEdge(0,1);

        expected = false;
        actual = adj.edgeExists(0,1);
        assertEquals("0-1 was removed",expected,actual);
    }


}
