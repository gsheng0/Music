package Music.basic;

import Music.DoublyLinkedList;
import Music.Jajtils;
import Music.MusicUtils;

public class Pitch implements Comparable<Pitch>{
    private char pitch;
    private int accidental = NATURAL;
    private int steps;
    private int octave = 5;
    public static final int DOUBLE_FLAT = -2;
    public static final int FLAT = -1;
    public static final int NATURAL = 0;
    public static final int SHARP = 1;
    public static final int DOUBLE_SHARP = 2;

    public Pitch(char pitch, int accidental, int octave)
    {
        this.pitch = Jajtils.toUpperCase(pitch);
        this.accidental = accidental;
        this.octave = octave;
        this.steps = MusicUtils.pitchToSteps.get(pitch) + accidental + octave * 12;
    }

    public Pitch(char pitch)
    {
        this(pitch, Pitch.NATURAL);
    }

    public Pitch(char pitch, int accidental)
    {
        this(pitch, accidental, 5);
    }
    public Pitch(String input)
    {
        input.toUpperCase();
        if(input.charAt(0) < 65 || input.charAt(0) > 71)
            throw new Error("\"" + input.charAt(0) + "\" is not a valid pitch");
        pitch = input.charAt(0);
        input = Jajtils.removeSpaces(input.substring(1));
        //allow it to count the amount of 'flat's and 'sharp's in the input and change the pitch and accidental accordingly

        if(input.charAt(0) == '#' || input.contains("SHARP"))
            accidental = Pitch.SHARP;
        else if(input.charAt(0) == 'B' || input.contains("FLAT"))
            accidental = Pitch.FLAT;
        else
            accidental = Pitch.NATURAL;
        this.steps = MusicUtils.pitchToSteps.get(pitch) + accidental + octave * 12;
    }

    public String toString(){
        return pitch + " " + MusicUtils.accidentalToNumber.get(accidental) + " " + octave;
    }

    public char getPitch() { return pitch; }
    public int getAccidental() { return accidental; }
    public int getOctave() { return octave; }
    public int getSteps() { return steps; }
    public Pitch raise(){
        steps++;
        int relativeSteps = steps%12;
        if(relativeSteps == 0)
            octave++;
        if(MusicUtils.stepsToPitch.get(relativeSteps) == null)
        {
            pitch = MusicUtils.stepsToPitch.get(relativeSteps - 1);
            accidental = Pitch.SHARP;
        }
        else {
            pitch = MusicUtils.stepsToPitch.get(relativeSteps);
            accidental = Pitch.NATURAL;
        }

        return this;
    }

    public Pitch lower(){
        steps--;
        int relativeSteps = steps%12;
        if(relativeSteps+1 == 12)
            octave--;
        if(MusicUtils.stepsToPitch.get(relativeSteps) == null)
        {
            pitch = MusicUtils.stepsToPitch.get((relativeSteps + 1)%12);
            accidental = Pitch.FLAT;
        }
        else {
            pitch = MusicUtils.stepsToPitch.get(relativeSteps);
            accidental = Pitch.NATURAL;
        }

        return this;
    }

    public Pitch raise(Interval interval)
    {
        int diatonicDistance = interval.getDiatonicInterval().getCardinalNumber();
        DoublyLinkedList.ListNode<Character> listNode = MusicUtils.pitches.get(MusicUtils.pitches.indexOf(this.pitch));
        for(int i = 0; i < diatonicDistance - 1; i++) {
            if(listNode.getValue() == 'G')
                octave++;
            listNode = listNode.getNext();
        }
        pitch = listNode.getValue();
        int target = steps + interval.getDistance();
        steps = MusicUtils.pitchToSteps.get(pitch) + accidental + octave * 12;
        int difference = target - steps;
        accidental += difference;
        return this;
    }

    public Pitch getPitchIntervalAbove(Interval interval)
    {
        Pitch output = new Pitch(pitch, accidental, octave);
        return output.raise(interval);
    }

    public Pitch lower(Interval interval)
    {
        int diatonicDistance = interval.getDiatonicInterval().getCardinalNumber();
        DoublyLinkedList<Character>.ListNode<Character> listNode = MusicUtils.pitches.get(MusicUtils.pitches.indexOf(this.pitch));
        for(int i = 0; i < diatonicDistance - 1; i++) {
            if(listNode.getValue() == 'A')
                octave--;
            listNode = listNode.getPrevious();
        }
        pitch = listNode.getValue();
        int target = steps - interval.getDistance();
        steps = MusicUtils.pitchToSteps.get(pitch) + accidental + octave * 12;
        int difference = target - steps;
        accidental += difference;
        return this;
    }

    public Pitch getPitchIntervalLower(Interval interval)
    {
        Pitch output = new Pitch(pitch, accidental, octave);
        return output.lower(interval);
    }

    public int compareTo(Pitch other)
    {
        if(other.steps > steps)
            return -1;
        else if(other.steps < steps)
            return 1;
        return 0;
    }

    public boolean higherThan(Pitch other)
    {
        return steps > other.steps;
    }

    public boolean lowerThan(Pitch other)
    {
        return steps < other.steps;
    }

    public boolean equals(Pitch other)
    {
        return other.steps == steps;
    }

}
