import java.util.*;
public class NumberGuess
{
    Random rand=new Random();
    Scanner s=new Scanner(System.in);
    void game()
    {
        int guess;
        int num=rand.nextInt(100)+1;
        while(true)
        {
            System.out.println("Enter your guess");
            guess=s.nextInt();
            if(guess>num)
            {
                System.out.println("Guess too high!");
            }
            else if(guess<num)
            {
                System.out.println("Guess too low!");
            }
            else 
            {
                System.out.println("Correct!");
                break;
            }
        }
    }
    public static void main()
    {
        NumberGuess g=new NumberGuess();
        g.game();
    }
}
