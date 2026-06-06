import java.util.*;
public class NumberGuess
{
    Random rand=new Random();
    Scanner s=new Scanner(System.in);
    void game()
    {
        int guess,attempt=0,num=0,difficulty,retry=0,maxattempt=0;
        System.out.println("Welcome to the Number guess game!");
        System.out.println("Choose your difficulty (By typing either 1,2 or 3)!");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("| 1. Easy - Guess a number between 1 and 100 in ten attempts     |");
        System.out.println("| 2. Normal - Guess a number between 1 and 100 in seven attempts |");
        System.out.println("| 3. Hard - Guess a number between 1 and 200 in seven attempts   |");
        System.out.println("|----------------------------------------------------------------|");
        difficulty=s.nextInt();
        if(difficulty==1)
        {
            num=rand.nextInt(100)+1;
            attempt=10;
            maxattempt=10;
            System.out.println("Easy mode chosen!");
        }
        else if(difficulty==2)
        {
            num=rand.nextInt(100)+1;
            attempt=7;
            maxattempt=7;
            System.out.println("Normal mode chosen!");
        }
        else if(difficulty==3)
        {
            num=rand.nextInt(200)+1;
            attempt=7;
            maxattempt=7;
            System.out.println("Hard mode chosen!");
        }
        else
        {
            System.out.println("Invalid difficulty");
        }
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
                System.out.println("You guessed the number in "+(maxattempt-attempt+1)+" attempts");
                break;
            }
        }
        if(attempt==0 && num!=0)
        {
            System.out.println("Game over :(");
            System.out.println("The number was "+num);
        }
        System.out.println();
        System.out.println("Want to play again? | Press 1 for yes | Press 2 for no |");
        retry=s.nextInt();
        if(retry==1)
        {
            game();
        }
    }
    public static void main()
    {
        int mode;
        NumberGuess g=new NumberGuess();
        g.game();
    }
}
