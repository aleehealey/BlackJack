import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> hand;
    
    public Hand(Card c1, Card c2)
    {
        hand = new ArrayList<Card>();
        hand.add(c1);
        hand.add(c2);
    }
    
    public void addCard(Card c)
    {
        hand.add(c);
    }
    
    public int getAces()
    {
        int aces = 0;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getRank() == "Ace")
            {
                aces++;
            }
        }
        return aces;
    }
    
    public int getValue()
    {
        int total = 0;
        for(int i = 0; i < hand.size(); i++)
        {
            total = hand.get(i).getValue() + total;
        }
        return total;
    }
    
    public ArrayList<Card> getCards()
    {
        return hand;
    }
}