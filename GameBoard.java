import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * Tuan .L
 * 2/3/2024
 */
public class GameBoard extends World
{
    private final int NUM_CARDS_IN_DECK = 27;
    private Dealer dealer = new Dealer(NUM_CARDS_IN_DECK);
    
    public GameBoard()
    {   
        super(430, 600, 1, false); 
        //new Tester(NUM_CARDS_IN_DECK);
        prepareScene();
    }

    public void prepareScene()
    {
        Scorekeeper.setScore(0);
        Player player = new Player(dealer);
        addObject(dealer, -30, -30);
        addObject(player, -30, -30);
    }
}
