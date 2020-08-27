package com.company.graphRepresentations;

import com.company.graphBasics.Edge;
import com.company.graphBasics.Vertex;

import java.util.ArrayList;

public class AdjacencyMatrix
{
    private int numberOfVerticies;
    public ArrayList<Vertex> vertices;
    public Edge[][] matrix;

    public AdjacencyMatrix(int numberOfVerticies)
    {
        matrix = new Edge[numberOfVerticies][numberOfVerticies];
        vertices = new ArrayList<>();
        for(int i =0;i<numberOfVerticies;i++)
        {
            vertices.add(new Vertex());
        }
    }

    public void addEdge(int u, int v, int w)
    {
        matrix[u][v] = new Edge(u,v,w);
    }

    public void removeEdge(int u, int v)
    {
        matrix[u][v] = null;
    }

    public boolean edgeExists(int u, int v)
    {
        return !(matrix[u][v]==null);
    }

    public Edge getEdge(int u, int v)
    {
        return matrix[u][v];
    }


    public int getNumberOfVerticies() {
        return numberOfVerticies;
    }

    public void setNumberOfVerticies(int numberOfVerticies) {
        this.numberOfVerticies = numberOfVerticies;
    }
}
