package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;
import Music.quality.interfaces.Mode;

import java.util.ArrayList;
import java.util.HashMap;

public class Scale {
    private Pitch root;
    private Class<? extends Mode> mode;
    private ArrayList<Pitch> pitches = new ArrayList<>();
    private HashMap<Integer, Integer> accidentals = new HashMap<>();

    public Scale(Pitch root, Class<? extends Mode> mode)
    {
        this.root = root;
        this.mode = mode;
        pitches.add(root);

        ArrayList<Interval> intervals = new ArrayList<>();
        try {
            intervals = mode.newInstance().getIntervalList();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        for (int i = 0; i < intervals.size(); i++) {
            Pitch prev = pitches.get(pitches.size() - 1);
            if(!accidentals.containsKey(prev.getAccidental()))
                accidentals.put(prev.getAccidental(), 0);
            accidentals.put(prev.getAccidental(), accidentals.get(prev.getAccidental()) + 1);
            pitches.add(pitches.get(pitches.size() - 1).getPitchIntervalAbove(intervals.get(i)));
        }
    }

    public Pitch getRoot()
    {
        return root;
    }
    public Class<? extends Mode> getMode()
    {
        return mode;
    }
    public ArrayList<Pitch> getPitches()
    {
        return pitches;
    }
    public Pitch getNthDegree(int n)
    {
        return pitches.get(n);
    }
    public HashMap<Integer, Integer> getAccidentals()
    {
        return accidentals;
    }
}
