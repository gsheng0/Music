package Music.basic;

public class Ordinal implements Comparable<Ordinal>{
    private int number;
    private String ordinal;
    private static String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    public Ordinal(int number)
    {
        this.number = number;
        switch (number % 100) {
            case 11:
            case 12:
            case 13:
                ordinal = number + "th";
                break;
            default:
                ordinal = number + suffixes[number % 10];
        }
    }
    public int getCardinalNumber() { return number; }
    public String toString() { return ordinal; }
    public int compareTo(Ordinal other)
    {
        if(other.number > number)
            return -1;
        else if(other.number < number)
            return 1;
        return 0;
    }
}
