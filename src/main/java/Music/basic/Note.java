package Music.basic;

public class Note
{
    private Rhythm rhythm;
    private Pitch pitch;
    public Note(Rhythm rhythm, Pitch pitch)
    {
        this.pitch = pitch;
        this.rhythm = rhythm;
    }
    public Note(Pitch pitch, Rhythm rhythm)
    {
        this(rhythm, pitch);
    }

    public Pitch getPitch() {
        return pitch;
    }
    public Rhythm getRhythm() { return rhythm; }


}
