package com.siddarth.partyat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.FileNotFoundException;
import java.lang.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

final String ID = "Bob";
        final ImageButton upvote1 = (ImageButton) findViewById(R.id.upvote1);
        upvote1.setImageResource(R.drawable.arrowup);
        upvote1.setAdjustViewBounds(true);
        final ImageButton downvote1 = (ImageButton) findViewById(R.id.downvote1);
        downvote1.setImageResource(R.drawable.arrowdown);
        downvote1.setAdjustViewBounds(true);
        final ImageButton upvote2 = (ImageButton) findViewById(R.id.upvote2);
        upvote2.setImageResource(R.drawable.arrowup);
        upvote2.setAdjustViewBounds(true);
        final ImageButton downvote2 = (ImageButton) findViewById(R.id.downvote2);
        downvote2.setImageResource(R.drawable.arrowdown);
        downvote2.setAdjustViewBounds(true);
        final ImageButton upvote3 = (ImageButton) findViewById(R.id.upvote3);
        upvote3.setImageResource(R.drawable.arrowup);
        upvote3.setAdjustViewBounds(true);
        final ImageButton downvote3 = (ImageButton) findViewById(R.id.downvote3);
        downvote3.setImageResource(R.drawable.arrowdown);
        downvote3.setAdjustViewBounds(true);
        final ImageButton upvote4 = (ImageButton) findViewById(R.id.upvote4);
        upvote4.setImageResource(R.drawable.arrowup);
        upvote4.setAdjustViewBounds(true);
        final ImageButton downvote4 = (ImageButton) findViewById(R.id.downvote4);
        downvote4.setImageResource(R.drawable.arrowdown);
        downvote4.setAdjustViewBounds(true);
        final ImageButton upvote5 = (ImageButton) findViewById(R.id.upvote5);
        upvote5.setImageResource(R.drawable.arrowup);
        upvote5.setAdjustViewBounds(true);
        final ImageButton downvote5 = (ImageButton) findViewById(R.id.downvote5);
        downvote5.setImageResource(R.drawable.arrowdown);
        downvote5.setAdjustViewBounds(true);
        final ImageButton upvote6 = (ImageButton) findViewById(R.id.upvote6);
        upvote6.setImageResource(R.drawable.arrowup);
        upvote6.setAdjustViewBounds(true);
        final ImageButton downvote6 = (ImageButton) findViewById(R.id.downvote6);
        downvote6.setImageResource(R.drawable.arrowdown);
        downvote6.setAdjustViewBounds(true);
        final ImageButton upvote7 = (ImageButton) findViewById(R.id.upvote7);
        upvote7.setImageResource(R.drawable.arrowup);
        upvote7.setAdjustViewBounds(true);
        final ImageButton downvote7 = (ImageButton) findViewById(R.id.downvote7);
        downvote7.setImageResource(R.drawable.arrowdown);
        downvote7.setAdjustViewBounds(true);
        final ImageButton upvote8 = (ImageButton) findViewById(R.id.upvote8);
        upvote8.setImageResource(R.drawable.arrowup);
        upvote8.setAdjustViewBounds(true);
        final ImageButton downvote8 = (ImageButton) findViewById(R.id.downvote8);
        downvote8.setImageResource(R.drawable.arrowdown);
        downvote8.setAdjustViewBounds(true);
        final ImageButton upvote9 = (ImageButton) findViewById(R.id.upvote9);
        upvote9.setImageResource(R.drawable.arrowup);
        upvote9.setAdjustViewBounds(true);
        final ImageButton downvote9 = (ImageButton) findViewById(R.id.downvote9);
        downvote9.setImageResource(R.drawable.arrowdown);
        downvote9.setAdjustViewBounds(true);
        final ImageButton upvote10 = (ImageButton) findViewById(R.id.upvote10);
        upvote10.setImageResource(R.drawable.arrowup);
        upvote10.setAdjustViewBounds(true);
        final ImageButton downvote10 = (ImageButton) findViewById(R.id.downvote10);
        downvote10.setImageResource(R.drawable.arrowdown);
        downvote10.setAdjustViewBounds(true);
        final ImageButton upvote11 = (ImageButton) findViewById(R.id.upvote11);
        upvote11.setImageResource(R.drawable.arrowup);
        upvote11.setAdjustViewBounds(true);
        final ImageButton downvote11 = (ImageButton) findViewById(R.id.downvote11);
        downvote11.setImageResource(R.drawable.arrowdown);
        downvote11.setAdjustViewBounds(true);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this,"1NppeKOMGLe0Mc8HXXOBKqmvJxhoAaRTDgt8H2zF", "ihg38mdnvZBXpOA9Hd6hNQfPnQn19WcHcoLpsvEx");
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("NewWire");
        final ArrayList<String> names = new ArrayList<String>();
        final ArrayList<Integer> pop = new ArrayList<Integer>();
        final ArrayList<Integer> votes = new ArrayList<Integer>();
        final ArrayList<String> music = new ArrayList<String>();
        final ArrayList<Boolean> PUID = new ArrayList<Boolean>();
        final ArrayList<ArrayList<Vote>> arr = new ArrayList<ArrayList<Vote>>();
        final ArrayList<String> hours = new ArrayList<String>();
        final ArrayList<ParseObject> array = new ArrayList<ParseObject>();
        query.findInBackground(new FindCallback<ParseObject>() {

            // this needs to be fixed
            public void done(List<ParseObject> objects, ParseException e)
            {
                if (e == null)
                    //for(ParseObject o: objects)
                    //{
                        //array.add(o);
                        for (ParseObject club : objects) {
                            names.add(club.getString("Name"));
                            pop.add(club.getInt("Population"));
                            votes.add(club.getInt("Votes"));
                            music.add(club.getString("Music"));
                            PUID.add(club.getBoolean("PUID"));
                            hours.add(club.getString("Hours"));
                            ParseFile file = (ParseFile)club.get("Vote_Queue");
                            final ArrayList<Vote> temp = new ArrayList<Vote>();
                            file.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] bytes, ParseException e) {
                                    if (e == null) {
                                        String s = new String(bytes);
                                        String[] tempArr = s.split(" ");
                                        temp.add(new Vote(tempArr[0], Integer.parseInt(tempArr[1]), Long.parseLong(tempArr[2])));
                                    }
                                }
                            });
                            arr.add(temp);

                        }
                    //}
            }});
        final Club terrace = new Club(arr.get(0),names.get(0), hours.get(0), "", PUID.get(0), false, music.get(0), pop.get(0));
        final Club cap = new Club(arr.get(1), names.get(1), hours.get(1), "", PUID.get(1), false, music.get(1), pop.get(1));
        final Club cloister = new Club(arr.get(2), names.get(2),  hours.get(2), "", PUID.get(2), false, music.get(2), pop.get(2));
        final Club cannon = new Club(arr.get(3), names.get(3),  hours.get(3), "", PUID.get(3), false, music.get(3), pop.get(3));
        final Club ti = new Club(arr.get(4), names.get(4),  hours.get(4), "", PUID.get(4), false, music.get(4), pop.get(4));
        final Club ivy = new Club(arr.get(5), names.get(5),  hours.get(5), "", PUID.get(5), false, music.get(5), pop.get(5));
        final Club cottage = new Club(arr.get(6), names.get(6),  hours.get(6), "", PUID.get(6), false, music.get(6), pop.get(6));
        final Club colonial = new Club(arr.get(7), names.get(7),  hours.get(7), "", PUID.get(7), false, music.get(7), pop.get(7));
        final Club quad = new Club(arr.get(8), names.get(8),  hours.get(8), "", PUID.get(8), false, music.get(8), pop.get(8));
        final Club charter = new Club(arr.get(9), names.get(9),  hours.get(9), "", PUID.get(9), false, music.get(9), pop.get(9));
        final Club tower = new Club(arr.get(10), names.get(10),  hours.get(10), "", PUID.get(10), false, music.get(10), pop.get(10));

        TextView clubName1 = (TextView) findViewById(R.id.clubName1);
        TextView clubName2 = (TextView) findViewById(R.id.clubName2);
        TextView clubName3 = (TextView) findViewById(R.id.clubName3);
        TextView clubName4 = (TextView) findViewById(R.id.clubName4);
        TextView clubName5 = (TextView) findViewById(R.id.clubName5);
        TextView clubName6 = (TextView) findViewById(R.id.clubName6);
        TextView clubName7 = (TextView) findViewById(R.id.clubName7);
        TextView clubName8 = (TextView) findViewById(R.id.clubName8);
        TextView clubName9 = (TextView) findViewById(R.id.clubName9);
        TextView clubName10 = (TextView) findViewById(R.id.clubName10);
        TextView clubName11 = (TextView) findViewById(R.id.clubName11);


        clubName1.setText(names.get(0));
        clubName2.setText(names.get(1));
        clubName3.setText(names.get(2));
        clubName4.setText(names.get(3));
        clubName5.setText(names.get(4));
        clubName6.setText(names.get(5));
        clubName7.setText(names.get(6));
        clubName8.setText(names.get(7));
        clubName9.setText(names.get(8));
        clubName10.setText(names.get(9));
        clubName11.setText(names.get(10));


        final TextView numPeople1 = (TextView) findViewById(R.id.numPeople1);
        final TextView vote1 = (TextView) findViewById(R.id.vote1);
        final TextView numPeople2 = (TextView) findViewById(R.id.numPeople2);
        final TextView vote2 = (TextView) findViewById(R.id.vote2);
        final TextView numPeople3 = (TextView) findViewById(R.id.numPeople3);
        final TextView vote3 = (TextView) findViewById(R.id.vote3);
        final TextView numPeople4 = (TextView) findViewById(R.id.numPeople4);
        final TextView vote4 = (TextView) findViewById(R.id.vote4);
        final TextView numPeople5 = (TextView) findViewById(R.id.numPeople5);
        final TextView vote5 = (TextView) findViewById(R.id.vote5);
        final TextView numPeople6 = (TextView) findViewById(R.id.numPeople6);
        final TextView vote6 = (TextView) findViewById(R.id.vote6);
        final TextView numPeople7 = (TextView) findViewById(R.id.numPeople7);
        final TextView vote7 = (TextView) findViewById(R.id.vote7);
        final TextView numPeople8 = (TextView) findViewById(R.id.numPeople8);
        final TextView vote8 = (TextView) findViewById(R.id.vote8);
        final TextView numPeople9 = (TextView) findViewById(R.id.numPeople9);
        final TextView vote9 = (TextView) findViewById(R.id.vote9);
        final TextView numPeople10 = (TextView) findViewById(R.id.numPeople10);
        final TextView vote10 = (TextView) findViewById(R.id.vote10);
        final TextView numPeople11 = (TextView) findViewById(R.id.numPeople11);
        final TextView vote11 = (TextView) findViewById(R.id.vote11);

        numPeople1.setText(pop.get(0));
        numPeople2.setText(pop.get(1));
        numPeople3.setText(pop.get(2));
        numPeople4.setText(pop.get(3));
        numPeople5.setText(pop.get(4));
        numPeople6.setText(pop.get(5));
        numPeople7.setText(pop.get(6));
        numPeople8.setText(pop.get(7));
        numPeople9.setText(pop.get(8));
        numPeople10.setText(pop.get(9));
        numPeople11.setText(pop.get(10));

        vote1.setText(votes.get(0));
        vote2.setText(votes.get(1));
        vote3.setText(votes.get(2));
        vote4.setText(votes.get(3));
        vote5.setText(votes.get(4));
        vote6.setText(votes.get(5));
        vote7.setText(votes.get(6));
        vote8.setText(votes.get(7));
        vote9.setText(votes.get(8));
        vote10.setText(votes.get(9));
        vote11.setText(votes.get(10));
        /*******************************************************************************
         * updown vote 1
         *******************************************************************************/
        upvote1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = terrace.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    terrace.votepq.remove();
                upvote1.setEnabled(false);
                downvote1.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                terrace.addVote(vote);
                numPeople1.setText(terrace.getnumPeople());
                vote1.setText(terrace.getVoteCount());
                ParseObject temp = new ParseObject("Terrace");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",terrace.getnumPeople());
                temp.put("Votes", terrace.getVoteCount());
                try{
                    temp.put("Vote_Queue", terrace.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = terrace.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    terrace.votepq.remove();
                upvote1.setEnabled(true);
                downvote1.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                terrace.addVote(vote);
                numPeople1.setText(terrace.getnumPeople());
                vote1.setText(terrace.getVoteCount());
                ParseObject temp = new ParseObject("Terrace");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",terrace.getnumPeople());
                temp.put("Votes", terrace.getVoteCount());
                try{
                    temp.put("Vote_Queue", terrace.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 2
         *******************************************************************************/
        upvote2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cap.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cap.votepq.remove();
                upvote2.setEnabled(false);
                downvote2.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                cap.addVote(vote);
                numPeople2.setText(cap.getnumPeople());
                vote2.setText(cap.getVoteCount());
                ParseObject temp = new ParseObject("Cap and Gown");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cap.getnumPeople());
                temp.put("Votes", cap.getVoteCount());
                try{
                    temp.put("Vote_Queue", cap.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cap.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cap.votepq.remove();
                upvote2.setEnabled(true);
                downvote2.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                cap.addVote(vote);
                numPeople2.setText(cap.getnumPeople());
                vote2.setText(cap.getVoteCount());
                ParseObject temp = new ParseObject("Cap and Gown");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population", cap.getnumPeople());
                temp.put("Votes", cap.getVoteCount());
                try{
                    temp.put("Vote_Queue", cap.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 3
         *******************************************************************************/
        upvote3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cloister.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cloister.votepq.remove();
                upvote3.setEnabled(false);
                downvote3.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                cloister.addVote(vote);
                numPeople3.setText(cloister.getnumPeople());
                vote3.setText(cloister.getVoteCount());
                ParseObject temp = new ParseObject("Cloister");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cloister.getnumPeople());
                temp.put("Votes", cloister.getVoteCount());
                try{
                    temp.put("Vote_Queue", cloister.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cloister.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cloister.votepq.remove();
                upvote3.setEnabled(true);
                downvote3.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                cloister.addVote(vote);
                numPeople3.setText(cloister.getnumPeople());
                vote3.setText(cloister.getVoteCount());
                ParseObject temp = new ParseObject("Cloister");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cloister.getnumPeople());
                temp.put("Votes", cloister.getVoteCount());
                try{
                    temp.put("Vote_Queue", cloister.toTextFile());}
                catch(Exception e){}                   temp.saveInBackground(new SaveCallback() {
                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null)
                    {
                    }
                    else
                    {
                        Log.d(getClass().getSimpleName(), "User update error:");
                    }
                }
            });
            };
        });

        /*******************************************************************************
         * updown vote 4
         *******************************************************************************/
        upvote4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cannon.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cannon.votepq.remove();
                upvote4.setEnabled(false);
                downvote4.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                cannon.addVote(vote);
                numPeople4.setText(cannon.getnumPeople());
                vote4.setText(cannon.getVoteCount());
                ParseObject temp = new ParseObject("Cannon");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cannon.getnumPeople());
                temp.put("Votes", cannon.getVoteCount());
                try{temp.put("Vote_Queue", cannon.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cannon.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cannon.votepq.remove();
                upvote4.setEnabled(true);
                downvote4.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                cannon.addVote(vote);
                numPeople4.setText(cannon.getnumPeople());
                vote4.setText(cannon.getVoteCount());
                ParseObject temp = new ParseObject("Cannon");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cannon.getnumPeople());
                temp.put("Votes", cannon.getVoteCount());
                try{temp.put("Vote_Queue", cannon.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 5
         *******************************************************************************/
        upvote5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = ti.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    ti.votepq.remove();
                upvote5.setEnabled(false);
                downvote5.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                ti.addVote(vote);
                numPeople5.setText(ti.getnumPeople());
                vote5.setText(ti.getVoteCount());
                ParseObject temp = new ParseObject("Tiger Inn");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",ti.getnumPeople());
                temp.put("Votes", ti.getVoteCount());
                try{
                    temp.put("Vote_Queue", ti.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = ti.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    ti.votepq.remove();
                upvote5.setEnabled(true);
                downvote5.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                ti.addVote(vote);
                numPeople5.setText(ti.getnumPeople());
                vote5.setText(ti.getVoteCount());
                ParseObject temp = new ParseObject("Tiger Inn");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",ti.getnumPeople());
                temp.put("Votes", ti.getVoteCount());
                try{
                    temp.put("Vote_Queue", ti.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 6
         *******************************************************************************/
        upvote6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = ivy.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    ivy.votepq.remove();
                upvote6.setEnabled(false);
                downvote6.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                ivy.addVote(vote);
                numPeople6.setText(ivy.getnumPeople());
                vote6.setText(ivy.getVoteCount());
                ParseObject temp = new ParseObject("Ivy");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",ivy.getnumPeople());
                temp.put("Votes", ivy.getVoteCount());
                try{
                    temp.put("Vote_Queue", ivy.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = ivy.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    ivy.votepq.remove();
                upvote6.setEnabled(true);
                downvote6.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                ivy.addVote(vote);
                numPeople6.setText(ivy.getnumPeople());
                vote6.setText(ivy.getVoteCount());
                ParseObject temp = new ParseObject("Ivy");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",ivy.getnumPeople());
                temp.put("Votes", ivy.getVoteCount());
                try{
                    temp.put("Vote_Queue", ivy.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 7
         *******************************************************************************/
        upvote7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cottage.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cottage.votepq.remove();
                upvote7.setEnabled(false);
                downvote7.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                cottage.addVote(vote);
                numPeople7.setText(cottage.getnumPeople());
                vote7.setText(cottage.getVoteCount());
                ParseObject temp = new ParseObject("Cottage");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cottage.getnumPeople());
                temp.put("Votes", cottage.getVoteCount());
                try{
                    temp.put("Vote_Queue", cottage.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = cottage.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    cottage.votepq.remove();
                upvote7.setEnabled(true);
                downvote7.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                cottage.addVote(vote);
                numPeople7.setText(cottage.getnumPeople());
                vote7.setText(cottage.getVoteCount());
                ParseObject temp = new ParseObject("Cottage");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",cottage.getnumPeople());
                temp.put("Votes", cottage.getVoteCount());
                try{
                    temp.put("Vote_Queue", cottage.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 8
         *******************************************************************************/
        upvote8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = colonial.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    colonial.votepq.remove();
                upvote8.setEnabled(false);
                downvote8.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                colonial.addVote(vote);
                numPeople8.setText(colonial.getnumPeople());
                vote8.setText(colonial.getVoteCount());
                ParseObject temp = new ParseObject("Colonial");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",colonial.getnumPeople());
                temp.put("Votes", colonial.getVoteCount());
                try{
                    temp.put("Vote_Queue", colonial.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = colonial.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    colonial.votepq.remove();
                upvote8.setEnabled(true);
                downvote8.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                colonial.addVote(vote);
                numPeople8.setText(colonial.getnumPeople());
                vote8.setText(colonial.getVoteCount());
                ParseObject temp = new ParseObject("Colonial");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",colonial.getnumPeople());
                temp.put("Votes", colonial.getVoteCount());
                try{
                    temp.put("Vote_Queue", colonial.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 9
         *******************************************************************************/
        upvote9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = quad.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    quad.votepq.remove();
                upvote9.setEnabled(false);
                downvote9.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                quad.addVote(vote);
                numPeople9.setText(quad.getnumPeople());
                vote9.setText(quad.getVoteCount());
                ParseObject temp = new ParseObject("Quad");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",quad.getnumPeople());
                temp.put("Votes", quad.getVoteCount());
                try{
                    temp.put("Vote_Queue", quad.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = quad.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    quad.votepq.remove();
                upvote9.setEnabled(true);
                downvote9.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                quad.addVote(vote);
                numPeople9.setText(quad.getnumPeople());
                vote9.setText(quad.getVoteCount());
                ParseObject temp = new ParseObject("Quad");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",quad.getnumPeople());
                temp.put("Votes", quad.getVoteCount());
                try{
                    temp.put("Vote_Queue", quad.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 10
         *******************************************************************************/
        upvote10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = charter.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    charter.votepq.remove();
                upvote10.setEnabled(false);
                downvote10.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                charter.addVote(vote);
                numPeople10.setText(charter.getnumPeople());
                vote10.setText(charter.getVoteCount());
                ParseObject temp = new ParseObject("Charter");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",charter.getnumPeople());
                temp.put("Votes", charter.getVoteCount());
                try{temp.put("Vote_Queue", charter.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });
        downvote10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vote recent = charter.votepq.peek();
                if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    charter.votepq.remove();
                upvote10.setEnabled(true);
                downvote10.setEnabled(false);
                Vote vote = new Vote(ID, -1, System.currentTimeMillis());
                charter.addVote(vote);
                numPeople10.setText(charter.getnumPeople());
                vote10.setText(charter.getVoteCount());
                ParseObject temp = new ParseObject("Charter");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population",charter.getnumPeople());
                temp.put("Votes", charter.getVoteCount());
                try{temp.put("Vote_Queue", charter.toTextFile());}
                catch(Exception e){}
                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null)
                        {
                        }
                        else
                        {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            };
        });

        /*******************************************************************************
         * updown vote 11
         *******************************************************************************/
        upvote11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Vote recent = tower.votepq.peek();
                if (recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                    tower.votepq.remove();
                upvote11.setEnabled(false);
                downvote11.setEnabled(true);
                Vote vote = new Vote(ID, 1, System.currentTimeMillis());
                tower.addVote(vote);
                numPeople11.setText(tower.getnumPeople());
                vote11.setText(tower.getVoteCount());
                ParseObject temp = new ParseObject("Tower");
                temp.remove("Population");
                temp.remove("Votes");
                temp.remove("Vote_Queue");
                temp.put("Population", tower.getnumPeople());
                temp.put("Votes", tower.getVoteCount());
                try {
                    temp.put("Vote_Queue", tower.toTextFile());
                } catch (Exception e) {
                }


                temp.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                        } else {
                            Log.d(getClass().getSimpleName(), "User update error:");
                        }
                    }
                });
            }
        });
    downvote11.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Vote recent = tower.votepq.peek();
            if(recent.getTime() * 1000 - System.currentTimeMillis() > 7.2e12)
                tower.votepq.remove();
            upvote11.setEnabled(true);
            downvote11.setEnabled(false);
            Vote vote = new Vote(ID, -1, System.currentTimeMillis());
            tower.addVote(vote);
            numPeople11.setText(tower.getnumPeople());
            vote11.setText(tower.getVoteCount());
            ParseObject temp = new ParseObject("Tower");
            temp.remove("Population");
            temp.remove("Votes");
            temp.remove("Vote_Queue");
            temp.put("Population",tower.getnumPeople());
            temp.put("Votes", tower.getVoteCount());
            try{
                temp.put("Vote_Queue", tower.toTextFile());
            }
            catch(Exception e){}

            temp.saveInBackground(new SaveCallback() {
                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null)
                    {
                    }
                    else
                    {
                        Log.d(getClass().getSimpleName(), "User update error:");
                    }
                }
            });
        };
    });
}

}


