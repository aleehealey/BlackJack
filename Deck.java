 

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    // variables
    private ArrayList<Card> cards;
    private Random gen;
    private int min;
    private int max;
    
    // constructor
    public Deck( String[] ranks, String[] suits, int[] values )
    {
        // instantiate the RNG
        gen = new Random();
        
        // don't forget to instantiate the arraylist!
        cards = new ArrayList<Card>();
        
        // populate the array
        for( int i = 0; i < suits.length; i++ )
        {
            for( int j = 0; j < ranks.length; j++ )
            {
                Card newCard = new Card( ranks[ j ], suits[ i ], values[ j ] );
                cards.add( newCard );
            }
        }
    }
    
    // methods
    public String toString()
    {
        String deckString = "";
        // go through the arraylist of cards and add them to the deckstring
        for( Card c : cards )
        {
            deckString += c + "\n";
        }
        return deckString;
    }
    
    public Card deal()
    {
        if( cards.size() > 0 )
        {
            Card dealtCard = cards.get( cards.size() - 1 );
            cards.remove( cards.size() - 1 );
            return dealtCard;
        }
        else return null;
    }
    
    public void selectionShuffle()
    {
        min = 0;
        max = cards.size() - 1;
        
        // for each position in the deck
        for( int i = 0; i < cards.size(); i++ )
        {
            // generate a random position
            int pos = gen.nextInt( (max-min) + 1 ) + min;
            
            // SWAP the card at the current position with the random position
            // get the card from the random position
            Card tempCard = cards.get( pos );
            
            // take the card at i and put it in pos
            cards.set( pos, cards.get( i ) );
            
            // take the tempCard and put it at i
            cards.set( i, tempCard );
        }
     
    }
    
    public void perfectShuffle()
    {
        // find the midpoint of the deck
        int mid = cards.size() / 2;
        
        // divide the deck from 1 to the midpoint (top half) and midpoint+1 to the end (bottom half).
        Card[] top = new Card[ mid ];
        Card[] bottom = new Card[ mid ];
        
        // copy the cards from the deck into the split arrays
        for( int i = 0; i < mid; i++ )
        {
            top[ i ] = cards.get( i );
            bottom[ i ] = cards.get( mid + i );
        }
        
        // make a new array and then alternate taking cards from the two halves until there are no cards left.
        ArrayList<Card> newCards = new ArrayList<Card>();
        
        for( int i = 0; i < mid; i++ )
        {
            newCards.add( top[ i ] );
            newCards.add( bottom[ i ] );
        }
        
        // replace the original array with our shuffled array.
        cards = newCards;
    }
}