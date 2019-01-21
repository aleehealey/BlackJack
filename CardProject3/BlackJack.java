import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
    /**
         * welcome to blackjack
         * 
         *  make a standard deck, shuffle a few times
         *  
         *  draw two cards, show the user
         *  draw two cards for the computer
         *  
         *  prompt to hit or stay as many times as the User wants
         *  
         *  do the computer's turn
         * 
         *  compare,
         *  
         *  declare the winner
         */
        
    public static void main(String args[])
    {
        int[] values = {11,2,3,4,5,6,7,8,9,10,10,10,10};
        String[] ranks = {"Ace","Two","Three","Four","Five","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        String[] suits = {"Hearts","Spades","Clubs","Diamonds"};
        
        Deck deck = new Deck(ranks, suits, values);
        
        for(int i = 0; i < 5; i++)
        {
            deck.selectionShuffle();
        }
        
        Hand userHand = new Hand(deck.deal(), deck.deal());
        Hand compHand = new Hand(deck.deal(), deck.deal());
        
        Scanner scan = new Scanner(System.in);
        // introduce user
        System.out.println("Hello! and welcome to BlackJack!" 
        + "\nYou should already know how to play so lets go!");
        
        boolean userBust = false;
        boolean userDesire = true;
        
        boolean compBust = false;
        boolean compDesire = true;
        
        int compValue = compHand.getValue();
        int userValue = userHand.getValue();
        
        while(userBust == false && userDesire == true)
        {
            // prompt user
            // show the user their cards
            // get user input
            // if user wants to hit then deal then a new card
            // check if they are still alive
            // check it the player has busted
            for(Card c : userHand.getCards())
            {
                System.out.println("You have a " + c);
            }
            
            userValue = userHand.getValue();
            int aces = userHand.getAces();
            
            System.out.println("Would you like to Hit? or Stay? (h/s)");
            String answer = scan.next();
            
            if(answer.equals("h"))
            {
                userHand.addCard(deck.deal());
            }
            else{
                userDesire = false;
            }
            
            if(userValue > 21)
            {
                while(aces > 0 && userValue > 21)
                {
                    userValue = userValue - 10;
                    aces--;
                }
                if(userValue > 21)
                {
                    userBust = true;
                }
            }
        }
        
        while(compBust == false && compDesire == true)
        {
            // prompt user
            // get user input
            // if user wants to hit then deal then a new card
            // check if they are still alive
            // check it the player has busted
            compValue = compHand.getValue();
            int aces = compHand.getAces();
            
            if(compValue < 17)
            {
                compHand.addCard(deck.deal());
            }
            else{
                compDesire = false;
            }
               
            if(compValue > 21)
            {
                while(aces > 0 && compValue > 21)
                {
                    compValue = compValue - 10;
                    aces--;
                }
                if(compValue > 21)
                {
                    compBust = true;
                }
            }
        }
        
        for(Card c : userHand.getCards())
        {
            System.out.println("You had a " + c);
        }
        
        for(Card c : compHand.getCards())
            {
                System.out.println("The Computer had a " + c);
            }  
            
        System.out.println("You had a value of " + userValue);
        System.out.println("The Computer had a value of " + compValue);
        
        if(userBust)System.out.println("You bust you Lose.");
        else if(compBust)System.out.println("The Computer busts you WIN!");
        else if(userValue > compValue)System.out.println("You WIN!");
        else System.out.println("You LOSE!");
    }
}