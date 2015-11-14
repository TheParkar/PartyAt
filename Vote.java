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
    public static String getName()
    {
        return name;
    }
    public static int getVote()
    {
        return orientation;
    }
    public static Timestamp getTimestamp()
    {
        return time;
    }
    public static void setVote(int newO)
    {
        orientation = newO;
    }
    public static void setTime(Timestamp newT)
    {
        time = newT;
    }
    public static compareTo(Vote v)
    {
        return time.compareTo(v.getTimestamp());
    }
}