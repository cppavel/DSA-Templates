package com.company.graphRepresentations;

import com.company.graphBasics.Edge;
import com.company.graphBasics.Vertex;

import java.util.ArrayList;

public class AdjacencyList
{
    private int numberOfVerticies;
    public ArrayList<ArrayList<Edge>> adjacencyList;
    public ArrayList<Vertex> vertices;

    public AdjacencyList(int numberOfVertices)
    {
        this.numberOfVerticies = numberOfVertices;
        adjacencyList = new ArrayList<>();
        vertices = new ArrayList<>(numberOfVertices);
        for(int i = 0; i< numberOfVertices;i++)
        {
            adjacencyList.add(new ArrayList<>());
            vertices.add(new Vertex());
        }

    }

    public void addEdge(int u, int v, int w)
    {
        adjacencyList.get(u).add(new Edge(u,v,w));
    }

    public void removeEdge(int u, int v)
    {
        Edge e = getEdge(u,v);

        if(e!=null)
        {
            adjacencyList.get(u).remove(e);
        }
    }

    public boolean edgeExists(int u, int v)
    {
        for (Edge e:adjacencyList.get(u))
        {
            if(e.getEdge().get(1)==v)
            {
                return true;
            }
        }

        return false;
    }

    public Edge getEdge(int u, int v)
    {
        for (Edge e:adjacencyList.get(u))
        {
            if(e.getEdge().get(1)==v)
            {
                return e;
            }
        }

        return null;
    }


    public int getNumberOfVerticies() {
        return numberOfVerticies;
    }

    public void setNumberOfVerticies(int numberOfVerticies) {
        this.numberOfVerticies = numberOfVerticies;
    }
}
