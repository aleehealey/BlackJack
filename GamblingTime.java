    import java.util.Scanner;
    
    public class GamblingTime
    {
        /**
         * first you start with 100 dollars
         * 
         * you bet a certian amount of money
         * you play a game
         * if you win then you get that amount of money back
         * if you lose then you lose that amount of money
         * 
         * then you ask them if you want to play again
         * if yes
         * then you play again
         * if no
         * then you stop with your money
         */
        public static void println(String s)
        {
            System.out.println(s);
        }
        public static void main(String args[])
        {
            println("\n======================================================");
            println("Welcome to the Everest Casino");
            println("Where you can have the Highest Highs \nfollowed shortly by the Lowest Lows of your life!");
            println("You start with $100.00. Lets see how lucky you are.\n");
            Scanner scan = new Scanner(System.in);
            BlackJackTable b = new BlackJackTable();
            double player = 100;
            boolean desire = true;
        
        do
        {
            println("BlackJack!");
            println("How much would you like to bet?");
            double bet;
            do
            {
                println("Note:You can't bet more than you have. Don't try");
                bet = scan.nextDouble();
            }while(bet > player);
            
            boolean win = b.play();
            if(win == true)
            {
                println("Congradulations! You win $" + bet);
                player = player + bet;
            }
            else if(win == false)
            {
                println("You Fail!!! You Lose $" + bet);
                player = player - bet;
            }
            
            println("You now have $" + player);
            if(player > 0)
            {
                println("Would you like to play again?(y or n)");
                String s = scan.next();
                if(s.equals("n"))desire = false;
            }
        }while(desire == true && player > 0);
        
        if(player > 100)
        {
            println("Yay! You came out on top! I guess you were lucky.\nEnjoy your $" + (player - 100));
        }
        else if(player == 100)
        {
            println("Damn... You broke even... Impressive.");
        }
        else
        {
            println("Welp, I guess the house won this time.\nWe'll make sure your $" + (100 - player) + " goes towards something good.");
        }
    }
}