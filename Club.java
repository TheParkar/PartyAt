import java.util.*;
import java.sql.*;
import java.io.*;

public class Club {
    public PriorityQueue<Vote> votepq;  // vote pq
    private String name;
    private String hours;
    private String theme;
    private boolean entry;
    private boolean isOpen;
    private String music;
    private int numPeople;
    //private int numFriends;
    
    public Club (ArrayList<Vote> v, String n, String h, String t, boolean e, boolean io, String m, int np){
        for (int i = 0; i < v.size(); i++)
        {
            votepq.add(v.get(i));
        }
        name = n;
        hours = h;
        theme = t;
        entry = e;
        isOpen = io;
        music = m;
        numPeople = np;
        //numFriends = nf;
    }

    public void addVote(Vote v)
    {
        votepq.add(v);
        numPeople++;
    }
    public int getVoteCount(){
        int votecount = 0;
        Vote[] votecountarr = new Vote[votepq.size()];
        votecountarr = votepq.toArray(votecountarr);
        for (int i = 0; i < votecountarr.length; i++)
        {
            votecount += votecountarr[i].getVote();
        }
        return votecount;
    }

    // public Vote[] pqToArray(){
    //     Vote[] votecountarr = new Vote[votepq.size()];
    //     votecountarr = votepq.toArray(votecountarr);
    //     return votecountarr;
    // }
    public String getName(){
        return name;
    }
    public String getHours(){
        return hours;
    }

    public String getTheme(){
        return theme;
    }

    public boolean getEntry(){
        return entry;
    }

    public String getMusic(){
        return music;
    }

    public int getnumPeople(){
        return numPeople;
    }
    

    public void setEntry(boolean e){
        entry = e;
    }

    public void setnumPeople(int np){
        numPeople = np;
    }

    public File toTextFile() throws FileNotFoundException{
        File fileout = new File(getName()+".txt");
        //try{
            PrintStream outfile = new PrintStream(new FileOutputStream(fileout));

            Vote[] votecountarr = new Vote[votepq.size()];
            votecountarr = votepq.toArray(votecountarr);
            for (int i = 0; i < votecountarr.length; i++)
            {
                outfile.println(votecountarr[i].toString());
            }

        //}
        // catch(FileNotFoundException e) {
        // System.out.println("File not found.");
        // }
        return fileout;
    }

    // public void setnumFriends(int nf){
    //     numFriends = nf;
    // }

    public String toString(){
        return name+hours+theme+entry+isOpen+music+numPeople;
    }

    public static void main (String[] args){
        // random test
        Timestamp t1 = new Timestamp(10000000);
        Vote a = new Vote("Bob", 1, t1);
        ArrayList<Vote> chartervotes = new ArrayList<Vote>();
        chartervotes.add(a);
        Club club = new Club(chartervotes, "Charter", "12-1","Charter Friday", false, false, "Live music", 0);
        System.out.println(club);
        

    }

}