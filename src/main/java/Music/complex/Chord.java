package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;

import java.util.ArrayList;

public class Chord extends MultiPitch {
    private ArrayList<Pitch> pitches = new ArrayList<>();
    private Pitch root;
    private ArrayList<Interval> intervals = new ArrayList<>();

    public Chord(Pitch root, ArrayList<Interval> intervals)
    {
        this.root = root;
        pitches.add(root);
        this.intervals = intervals;
        for(int i = 0; i < intervals.size(); i++)
            pitches.add(pitches.get(pitches.size() - 1).getPitchIntervalAbove(intervals.get(i)));
    }
    public Chord(ArrayList<Pitch> pitches)
    {
        root = pitches.get(0);
        this.pitches = pitches;
        for(int i = 0; i < pitches.size() - 1; i++)
            intervals.add(new Interval(pitches.get(i), pitches.get(i - 1)));
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

}
