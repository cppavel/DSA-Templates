package com.company.graphBasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Edge
{
    private int u, v, w;

    private Map<String, String> attributes = new HashMap<String, String>();

    public Edge(int u, int v, int w)
    {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public ArrayList<Integer> getEdge()
    {
        ArrayList<Integer> returnValue = new ArrayList<>();
        returnValue.add(u); returnValue.add(v); returnValue.add(w);
        return returnValue;
    }

    public void addAttribute(String key, String value)
    {
        attributes.put(key,value);
    }

    public void removeAttribute(String key)
    {
        attributes.remove(key);
    }

    public void getAttribute(String key)
    {
        attributes.get(key);
    }
}
