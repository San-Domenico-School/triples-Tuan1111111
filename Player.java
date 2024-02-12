import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * Tuan .L
 * 2/2/2024
 */
public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player(Dealer i)
    {
        dealer = i;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
    }
    
    public void act()   
    {
        selectCards();
        boolean setCardsSelected = setCardsSelect();
        if(setCardsSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
    
    public void addedToWorld(World i)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    //select the card if click on and deselect the card if click on again
    private void selectCards()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(cardsOnBoard.get(i).getIsSelected())
                {
                    cardsOnBoard.get(i).setIsSelected(false);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                    selectedCardsIndex.remove(selectedCardsIndex.indexOf(i));
                }
                else
                {
                    cardsOnBoard.get(i).setIsSelected(true);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());                    
                    selectedCardsIndex.add(i);
                }
            }
        }
    }
    
    //reset the card selected
    private void resetCardsSelected()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
            cardsOnBoard.get(i).setIsSelected(false);
              
        }
        selectedCardsIndex.clear();
    }
    
    //set the cards selected
    private boolean setCardsSelect()
    {
        if(selectedCardsIndex.size() == 3)
        {
            cardsSelected[0] = cardsOnBoard.get(selectedCardsIndex.get(0));
            cardsSelected[1] = cardsOnBoard.get(selectedCardsIndex.get(1));
            cardsSelected[2] = cardsOnBoard.get(selectedCardsIndex.get(2));
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
