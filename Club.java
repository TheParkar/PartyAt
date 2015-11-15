package com.siddarth.partyat;
import java.util.*;
import java.sql.*; // timestamp
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
        votepq = new PriorityQueue<Vote>();
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
    // get vote count (net up/down) of each club
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

    // priority queue to text file
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

    public static void main (String[] args) throws FileNotFoundException{
        // random test
        long t1 = 10000000;
        long t2 = 20000000;
        Vote a = new Vote("Bob", 1, t1);
        Vote b = new Vote("Sid", -1, t2);

        ArrayList<Vote> chartervotes = new ArrayList<Vote>();
        chartervotes.add(a);
        chartervotes.add(b);
        Club club = new Club(chartervotes, "Charter", "12-1","Charter Friday", false, false, "Live music", 0);
        System.out.println(club);
        System.out.println();

        // test of toTextFile()
        Scanner infile = new Scanner(club.toTextFile());
        while (infile.hasNextLine())
        {
            System.out.println(infile.nextLine());
        }
        

    }

}