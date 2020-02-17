package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;
import Music.quality.interfaces.SeventhChordQuality;

import java.util.ArrayList;

public class SeventhChord  extends StandardChord {
    private Class<? extends SeventhChordQuality> quality;
    private Pitch root;
    private ArrayList<Pitch> pitches;
    private ArrayList<Interval> intervals;

    public SeventhChord(Pitch root, Class<? extends SeventhChordQuality> quality)
    {
        this.quality = quality;
        this.root = root;
        pitches.add(root);

        ArrayList<Interval> intervals = new ArrayList<>();
        try{
            intervals = quality.newInstance().getChordIntervals();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        for(int i = 0; i < intervals.size(); i++)
            pitches.add(pitches.get(pitches.size() - 1).getPitchIntervalAbove(intervals.get(i)));
    }

    @Override
    public ArrayList<Pitch> getPitches() {
        return pitches;
    }

    @Override
    public Pitch getRoot() {
        return root;
    }

    @Override
    public ArrayList<Interval> getIntervalList() {
        return intervals;
    }

    @Override
    public int pitchCount() {
        return pitches.size();
    }

    @Override
    public Class getQuality() {
        return quality;
    }
}
