import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * Tuan .L 
 * 2/8/2024
 */
public class Dealer extends Actor
{
    private Deck deck;
    ArrayList<Card> cardOnBoard;
    ArrayList<Integer> selectedCardsIndex;
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
    
    //deal the board
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
    
    //set the score and cards remaining on screen
    public void setUI()
    {
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(String.valueOf(numCardsInDeck), 312, 468);
        getWorld().showText(String.valueOf(score), 312, 504);
    }
    
    //end game once no card left
    public void endGame()
    {
        if(triplesRemaining == 0)
        {
            Greenfoot.stop();
        }
    }
    
    //check if the selected cards are triple
    public void checkIfTriple()
    {
        boolean yes = true;
        if((cardsSelected[0].getColor() == cardsSelected[1].getColor()) && (cardsSelected[0].getColor() == cardsSelected[2].getColor()))
        {
            
        }
        else if((cardsSelected[0].getColor() != cardsSelected[1].getColor()) && (cardsSelected[2].getColor() != cardsSelected[1].getColor()) && (cardsSelected[0].getColor() != cardsSelected[2].getColor()))
        {
            
        }
        else
        {
            yes = false;
        }
        
        if((cardsSelected[0].getShape() == cardsSelected[1].getShape()) && (cardsSelected[0].getShape() == cardsSelected[2].getShape()))
        {
            
        }
        else if((cardsSelected[0].getShape() != cardsSelected[1].getShape()) && (cardsSelected[2].getShape() != cardsSelected[1].getShape()) && (cardsSelected[0].getShape() != cardsSelected[2].getShape()))
        {
            
        }
        else
        {
            yes = false;
        }
        
        if((cardsSelected[0].getShading() != cardsSelected[1].getShading()) && (cardsSelected[2].getShading() != cardsSelected[1].getShading()) && (cardsSelected[0].getShading() != cardsSelected[2].getShading()))
        {
            
        }
        else if((cardsSelected[0].getShading() == cardsSelected[1].getShading()) && (cardsSelected[0].getShading() == cardsSelected[2].getShading()))
        {
                        
        }
        else
        {
            yes = false;
        }
        
        if((cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()) && (cardsSelected[2].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()) && (cardsSelected[0].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes()))
        {
            
        }
        else if((cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes()) && (cardsSelected[0].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes()))
        {
                        
        }
        else
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
    
    //what to do once it is a triple: deal new cards on board, add score
    public void actionIfTriple()
    {
        for(int i = 0; i < 3; i++)
        {
            int xCoor = cardsSelected[i].getX();
            int yCoor = cardsSelected[i].getY();
            Animations.slideAndTurn(cardsSelected[i]);
            if(numCardsInDeck > 15)
            {
            
               Card newCard = deck.getTopCard();
               for(int o = 0; o < cardOnBoard.size(); o ++)
                {
                    if(cardsSelected[i].equals(cardOnBoard.get(o)))
                    {
                        cardOnBoard.set(o, newCard);
                        numCardsInDeck --;
                    }
                }
                getWorld().addObject(newCard, xCoor, yCoor);
            }
            else
            {
                numCardsInDeck --;
            }
            
            triplesRemaining --;
            Scorekeeper.updateScore();
            setUI();
        }
    }
    
    public void setCardsSelected(ArrayList<Card> cardOnBoard, ArrayList<Integer> selectedCardsIndex, Card[] cardsSelected)
    {
        this.cardOnBoard = cardOnBoard;
        this.cardsSelected = cardsSelected;
        this.selectedCardsIndex = selectedCardsIndex;
    }
}
