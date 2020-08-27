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

    public String getAttribute(String key)
    {
        return attributes.get(key);
    }



}
