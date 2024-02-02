/**
 * Write a description of class Scorekeeper here.
 * 
 * Tuan .Le
 * 1/11/2024
 */
public class Scorekeeper  
{
    private static int deckSize;
    private static int score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int newDeckSize)
    {
        deckSize = newDeckSize;
    }
    
    public static void updateScore()
    {
        long duration = (System.currentTimeMillis() - startTime)/1000;
        score += (float)1000*((float)1+ (float)9/Math.pow(100, ((float)duration/240)));
    }
    
    public static int getScore()
    {
        return score;
    }
}
