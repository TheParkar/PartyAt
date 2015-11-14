public class Club {
    private int votes;
    private String hours;
    private String theme;
    private boolean entry;
    private String music;
    private int numPeople;
    private int numFriends;
    
    public Club (int v, String h, String t, boolean e, String m, int np, int nf){
        votes=v;
        hours=h;
        theme=t;
        entry=e;
        music=m;
        numPeople=np;
        numFriends=nf;
    }

    public int getVotes(){
        return votes;
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

    public int getnumFriends(){
        return numFriends;
    }
    
    public void upvote(){
        votes++;
    }

    public void downvote(){
        votes--;
    }

    public void setEntry(boolean e){
        entry=e;
    }

    public void setnumPeople(int np){
        numPeople=np;
    }

    public void setnumFriends(int nf){
        numFriends=nf;
    }

    public static void main (String[] args){
        Club club = new Club(0,"12-1","Charter Friday", false, "Live music", 102,11);
        System.out.println(club);

    }
    public String toString(){
        return getVotes()+getHours()+getTheme()+getEntry()
            +getMusic()+getnumPeople()+getnumFriends();
    }
}