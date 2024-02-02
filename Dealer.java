import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private Deck deck;
    ArrayList<Card> cardOnBoard;
    ArrayList<Integer> selectedCardIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck, triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World i)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        int marginY = 45;
        int marginX = 73;
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 5; column++)
            {
                getWorld().addObject(deck.getTopCard(), marginX + row*140, marginY + column*80);
            }
        }
    }
    
    public void setUI()
    {
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(String.valueOf(numCardsInDeck), 312, 468);
        getWorld().showText(String.valueOf(score), 312, 504);
    }
        
    public void endGame()
    {
        
    }
    
    public void checkIfTriple()
    {
        boolean yes = true;
        if(!(cardsSelected[0].getColor() == cardsSelected[1].getColor() && cardsSelected[0].getColor() == cardsSelected[2].getColor()))
        {
            yes = false;
        }
        else if(!((cardsSelected[0].getColor() != cardsSelected[1].getColor()) && (cardsSelected[2].getColor() != cardsSelected[1].getColor()) && (cardsSelected[0].getColor() != cardsSelected[2].getColor())))
        {
            yes = false;
        }
        
        if(!(cardsSelected[0].getShape() == cardsSelected[1].getShape() && cardsSelected[0].getShape() == cardsSelected[2].getShape()))
        {
            yes = false;
        }
        else if(!((cardsSelected[0].getShape() != cardsSelected[1].getShape()) && (cardsSelected[2].getShape() != cardsSelected[1].getShape()) && (cardsSelected[0].getShape() != cardsSelected[2].getShape())))
        {
            yes = false;
        }
        
        if(!((cardsSelected[0].getShading() != cardsSelected[1].getShading()) && (cardsSelected[2].getShading() != cardsSelected[1].getShading()) && (cardsSelected[0].getShading() != cardsSelected[2].getShading())))
        {
            yes = false;
        }
        else if(!(cardsSelected[0].getShading() == cardsSelected[1].getShading() && cardsSelected[0].getShading() == cardsSelected[2].getShading()))
        {
            yes = false;            
        }
        
        if(!((cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()) && (cardsSelected[2].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()) && (cardsSelected[0].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes())))
        {
            yes = false;
        }
        else if(!(cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes() && cardsSelected[0].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes()))
        {
            yes = false;            
        }

        if(yes)
        {
            actionIfTriple();
        }
        else
        {
            Greenfoot.playSound("wobble.wav");
        }
    }
    
    public void actionIfTriple()
    {
        
    }
    
    public void setCardsSelected(ArrayList<Card> cardOnBoard, ArrayList<Integer> selectedCardsInDeck, Card[] cardsSelected)
    {
        
    }
}
