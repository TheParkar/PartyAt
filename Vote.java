import java.sql.*;

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
}