package com.company.graphSearch;

import com.company.graphBasics.Edge;
import com.company.graphBasics.Vertex;
import com.company.graphRepresentations.AdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    public static void breadthFirstSearch(AdjacencyList graph, int source)
    {

        for(int i = 0; i < graph.getNumberOfVerticies();i++)
        {
            if (i != source)
            {
                graph.vertices.get(i).addAttribute("color", "white");
                graph.vertices.get(i).addAttribute("distance", "inf");
                graph.vertices.get(i).addAttribute("parent", "none");
            }
        }

            graph.vertices.get(source).addAttribute("color","gray");
            graph.vertices.get(source).addAttribute("distance","0");
            graph.vertices.get(source).addAttribute("parent","none");

            Queue<Integer> queue = new LinkedList<Integer>();

            queue.add(source);

            while (!queue.isEmpty())
            {
                int u = queue.remove();

                for (Edge e:graph.adjacencyList.get(u))
                {
                    ArrayList<Integer> edge = e.getEdge();

                    int v = edge.get(1);

                    if(graph.vertices.get(v).getAttribute("color").equals("white"))
                    {
                        graph.vertices.get(v).addAttribute("color","gray");
                        graph.vertices.get(v).addAttribute("distance", String.valueOf(Integer.parseInt(graph.vertices.
                                get(u).getAttribute("distance")) + 1));
                        graph.vertices.get(v).addAttribute("parent",String.valueOf(u));
                        queue.add(v);
                    }
                }
                graph.vertices.get(u).addAttribute("color","black");
            }

    }

    public static void getPath(AdjacencyList adj, ArrayList<Integer> path, int source, int destination)
    {
        breadthFirstSearch(adj, source);
        if (destination == source)
        {
            path.add(source);
        }
        else if (adj.vertices.get(destination).getAttribute("parent").equals("none"))
        {
            path = null;
        }
        else
        {
            getPath(adj, path, source, Integer.valueOf(adj.vertices.get(destination).getAttribute("parent")));
            path.add(destination);
        }

    }
}
