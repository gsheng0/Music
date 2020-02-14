package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;
import Music.quality.interfaces.TriadQuality;

import java.util.ArrayList;

public class Triad extends Chord {
    private ArrayList<Pitch> pitches = new ArrayList<>();
    private Pitch root;
    private Class<? extends TriadQuality> quality;

    public Triad(Pitch root, Class<? extends TriadQuality> quality)
    {
        this.quality = quality;
        this.root = root;
        pitches.add(root);

        ArrayList<Interval> intervals = new ArrayList<>();
        try{
            intervals = quality.newInstance().getTriadIntervals();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        for(int i = 0; i < 2; i++)
            pitches.add(pitches.get(pitches.size() - 1).getPitchIntervalAbove(intervals.get(i)));
    }


    public ArrayList<Pitch> getPitches() { return pitches; }
    public Pitch getRoot() { return root; }
    public ArrayList<Interval> getIntervalList()
    {
        ArrayList<Interval> intervals = new ArrayList<>();
        try
        {
            intervals = quality.newInstance().getTriadIntervals();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return intervals;
    }

    public Class<? extends TriadQuality> getQuality() {
        return quality;
    }
    public String toString() { return pitches.get(0) + " " + pitches.get(1) + " " + pitches.get(2); }
    public int pitchCount() { return pitches.size(); }
}
