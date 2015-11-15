import java.sql.*;
import java.lang.*;

public class Vote implements Comparable<Vote>
{
    String name;
    int orientation;
    Timestamp time;
    public Vote(String n, int o, Timestamp t)
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
    public Timestamp getTimestamp()
    {
        return time;
    }
    public void setVote(int newO)
    {
        orientation = newO;
    }
    public void setTime(Timestamp newT)
    {
        time = newT;
    }
    public int compareTo(Vote v)
    {
        return time.compareTo(v.getTimestamp());
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
        Timestamp t = new Timestamp(0);
        Vote v1 = new Vote(n, o, t);
        System.out.println(v1);
    }
}