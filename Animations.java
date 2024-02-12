import greenfoot.*;
/**
 * Write a description of class Animations here.
 * 
 * Tuan .L
 * 1/11/2024
 */
public class Animations  
{
    public static void wobble(Card[] i)
    {
        Greenfoot.playSound("wobble.wav");
    }
    public static void slideAndTurn(Card i)
    {
        Greenfoot.playSound("swoosh.wav");
        i.activateAnimation = true;
    }
}
