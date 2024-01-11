/**
 * Write a description of class Scorekeeper here.
 * 
 * Tuan .Le
 * 1/11/2024
 */
public class Scorekeeper  
{
    private static int deckSize = 27;
    private static long scoreMultiplier = 100000;
    private static int score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int newDeckSize)
    {
        deckSize = newDeckSize;
    }
    
    public static void updateScore()
    {
        if(scoreMultiplier >=50)
        {
            scoreMultiplier = 100000 / (System.currentTimeMillis()*1000);
        }
        score += scoreMultiplier;
    }
    
    public static int getScore()
    {
        return score;
    }
}
