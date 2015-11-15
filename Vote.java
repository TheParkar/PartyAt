package com.siddarth.partyat;
import java.sql.*;  // timestamp
import java.lang.*;

// vote object, part of PQ
public class Vote implements Comparable<Vote>
{
    String name;
    int orientation;
    long time;
    public Vote(String n, int o, long t)
    {
    name = n;
    orientation = o;
    time = t;
    }
    public String getName()
    {
        return name;
    }
    public int getVote()
    {
        return orientation;
    }
    public long getTime()
    {
        return time;
    }
    public void setVote(int newO)
    {
        orientation = newO;
    }
    public void setTime(long newT)
    {
        time = newT;
    }
    public int compareTo(Vote v)
    {
        return (int)(time - v.getTime()); // check the priority
    }
    public String toString()
    {
        String s = name + " " + orientation + " " + time;
        return s;
    }
    public static void main(String[] args)
    {
        String n = "bob";
        int o = 1;
    }
}