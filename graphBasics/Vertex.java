package com.company.graphBasics;

import java.util.HashMap;
import java.util.Map;

public class Vertex
{
    private Map<String, String> attributes = new HashMap<String, String>();

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
