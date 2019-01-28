import java.util.ArrayList;
import java.util.Random;

public class StandardDeck extends Deck
{
    private ArrayList<Card> cards;
    private Random gen;
    private int min;
    private int max;
    public StandardDeck( String[] ranks, String[] suits, int[] values )
    {
        /*int[] values = {11,2,3,4,5,6,7,8,9,10,10,10,10};
        String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        String[] suits = {"Hearts","Spades","Clubs","Diamonds"};*/
        super(ranks, suits, values);
    }
    
}