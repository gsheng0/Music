package Music;

public class Jajtils
{
    public static int randInt(int min, int max)
    {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    public static String removeNonAlphaNumeric(String str)
    {
        String output = "";
        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58) || (ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123))
                output += str.charAt(i);
        }
        return output;
    }
    public static String removeNonAlphaNumeric(String str, boolean keepSpaces)
    {
        String output = "";
        if(!keepSpaces)
            return removeNonAlphaNumeric(str);

        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58) || (ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123) || ascii == 32)
                output += str.charAt(i);
        }

        return output;
    }

    public static String removeNonAlphabetic(String str, boolean keepSpaces)
    {
        String output = "";
        if(!keepSpaces)
            return removeNonAlphabetic(str);

        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123) || ascii == 32)
                output += str.charAt(i);
        }
        return output;

    }
    public static String removeNonAlphabetic(String str)
    {
        String output = "";
        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123))
                output += str.charAt(i);
        }
        return output;

    }

    public static String removeNonNumeric(String str, boolean keepSpaces)
    {
        String output = "";
        if(!keepSpaces)
            return removeNonNumeric(str);

        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58) || ascii == 32)
                output += str.charAt(i);
        }
        return output;
    }

    public static String removeNonNumeric(String str)
    {
        String output = "";
        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58))
                output += str.charAt(i);
        }
        return output;
    }

    public static String removeNonNumericDecimal(String str, boolean keepSpaces)
    {
        String output = "";
        if(!keepSpaces)
            return removeNonNumeric(str);

        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58) || ascii == 46 || ascii == 47)
                output += str.charAt(i);
        }
        return output;
    }

    public static String removeNonNumericDecimal(String str)
    {
        String output = "";
        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if((ascii > 47 && ascii < 58) || ascii == 46 || ascii == 47)
                output += str.charAt(i);
        }
        return output;
    }

    public static String removeSpaces(String str)
    {
        String output = "";
        for(int i = 0; i < str.length(); i++)
        {
            int ascii = str.charAt(i);
            if(ascii != 32)
                output += str.charAt(i);
        }
        return output;
    }

    public static int parseInt(String str)
    {
        if(str.length() > 0)
            return Integer.parseInt(str);
        else
            return 0;
    }

    public static double parseDouble(String str)
    {
        if(str.length() > 0)
            return Double.parseDouble(str);
        else
            return 0;
    }


    public static void print(String[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.println(i + ": " + arr[i]);
    }

    public static double processFraction(String fraction)
    {
        if(!fraction.contains("/"))
            return parseDouble(fraction);
        String[] split = fraction.split("/");
        double numerator = Double.parseDouble(split[0]);
        double denominator = Double.parseDouble(split[1]);

        return numerator/denominator;
    }

    public static char toUpperCase(char c)
    {
        return ("" + c).toUpperCase().charAt(0);
    }

    public static char toLowerCase(char c)
    {
        return ("" + c).toLowerCase().charAt(0);
    }
}

