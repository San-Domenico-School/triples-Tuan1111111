import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * Tuan .L
 * 1/9/2024
 */

public class Card extends Actor
{
    private Shape shape;
    private Color color;
    private boolean isSelected = false;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    
    public enum Shape
    {
       CIRCLE, TRIANGLE, SQUARE, NO_SHAPE
    }
   
    public enum Color
    {
       BLUE, GREEN, RED, NO_COLOR
    }
    
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        setImage(cardImage);
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public Shape getShape()
    {
        return shape;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    
    public int getShading()
    {
        return shading;
    }
    
    public void setIsSelected(boolean newSelect)
    {
        this.isSelected = newSelect;
    }
}

