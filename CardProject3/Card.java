public class Card
{
    // variables
    private String rank;
    private String suit;
    private int value;
    
    // constructor
    public Card( String rank, String suit, int value )
    {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }
    
    // methods
    public String getRank()
    {
        return rank;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String toString()
    {
        String cardString = rank + " of " + suit + " (value = " + value + ")";
        return cardString;
    }
    
}