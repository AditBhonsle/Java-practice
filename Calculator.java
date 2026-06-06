import java.util.*;
public class Calculator
{
    char op;                        // Op=operation
    int num1,num2;
    Scanner s=new Scanner(System.in);
    void calculate()
    {
        while(true)
        {
            System.out.println();
            System.out.println("Welcome to Calculator");
            System.out.println("Choose any of the following operations!");
            System.out.println("+ (Addition)");
            System.out.println("- (Subtraction)");
            System.out.println("* (Multiplication)");
            System.out.println("/ (Division)");
            System.out.println("% (Remainder)");
            System.out.println("Q (Exit the calculator)");
            op=s.next().charAt(0);
            if(op=='Q' || op=='q')
            {
                System.out.println("Thanks for using the calculator!");
                break;
            }
            else
            {
                if(op!='+' && op!='-' && op!='*' && op!='/' && op!='%')
                {
                    System.out.println("Invalid operation");
                }
                else
                {
                    System.out.println("Enter number 1");
                    num1=s.nextInt();
                    System.out.println("Enter number 2");
                    num2=s.nextInt();
                    if(num2==0 && (op=='/' || op=='%'))
                    {
                        System.out.println("Can't divide by zero");
                    }
                    else
                    {
                        switch(op)
                        {
                            case '+':
                                System.out.println("Result = "+(num1+num2));
                                break;
                            case '-':
                                System.out.println("Result = "+(num1-num2));
                                break;
                            case '*':
                                System.out.println("Result = "+(num1*num2));
                                break;
                            case '/':
                                System.out.println("Result = "+(num1/num2));
                                break;
                            default:
                                System.out.println("Result = "+(num1%num2));
                                break;
                        }
                    }
                }
            }
        }
    }
    public static void main()
    {
        Calculator c=new Calculator();
        c.calculate();
    }
}
