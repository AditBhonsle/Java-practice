import java.util.*;
public class NumberGuess
{
    Random rand=new Random();
    Scanner s=new Scanner(System.in);
    void game()
    {
        int guess,attempt=7;
        int num=rand.nextInt(100)+1;
        System.out.println("Welcome to the Number guess game!");
        System.out.println("You have to guess a number between 1 and 100 in 7 attempts!");
        while(attempt>0)
        {
            System.out.println();
            System.out.println("Enter your guess ("+attempt+" attempts left!)");
            guess=s.nextInt();
            if(guess>num)
            {
                System.out.println("Guess is too high!");
                attempt--;
            }
            else if(guess<num)
            {
                System.out.println("Guess is too low!");
                attempt--;
            }
            else 
            {
                System.out.println("Correct!");
                System.out.println("You guessed the number in "+(8-attempt)+" attempts");
                break;
            }
        }
        if(attempt==0)
        {
            System.out.println("Game over :(");
            System.out.println("The number was "+num);
        }
    }
    public static void main()
    {
        NumberGuess g=new NumberGuess();
        g.game();
    }
}
