import java.util.*;
public class Calculator
{
    char op;                        // Op=operation
    int num1,num2,result=0;
    ArrayList<String> history=new ArrayList<String>();
    Scanner s=new Scanner(System.in);
    void display()
    {
        System.out.println();
        System.out.println("Welcome to Calculator");
        System.out.println("Choose any of the following operations!");
        System.out.println("+ (Addition)");
        System.out.println("- (Subtraction)");
        System.out.println("* (Multiplication)");
        System.out.println("/ (Division)");
        System.out.println("% (Remainder)");
        System.out.println("H (History)");
        System.out.println("Q (Exit the calculator)");
    }

    void accept()
    {
        System.out.println("Enter number 1");
        num1=s.nextInt();
        System.out.println("Enter number 2");
        num2=s.nextInt();
    }

    void solve()
    {
        switch(op)
        {
            case '+':
                result=num1+num2;
                System.out.println(num1+" + "+num2+" = "+result);
                history.add(num1+" + "+num2+" = "+result);
                break;
            case '-':
                result=num1-num2;
                System.out.println(num1+" - "+num2+" = "+result);
                history.add(num1+" - "+num2+" = "+result);
                break;
            case '*':
                result=num1*num2;
                System.out.println(num1+" * "+num2+" = "+result);
                history.add(num1+" * "+num2+" = "+result);
                break;
            case '/':
                result=num1/num2;
                System.out.println(num1+" / "+num2+" = "+result);
                history.add(num1+" / "+num2+" = "+result);
                break;
            case '%':
                result=num1%num2;
                System.out.println(num1+" % "+num2+" = "+result);
                history.add(num1+" % "+num2+" = "+result);
                break;

        }
    }

    void viewHistory()
    {
        if(history.isEmpty())
        {
            System.out.println("No history found");
        }
        else
        {
            System.out.println("History:");
            for(String s:history)
            {
                System.out.println(s);
            }
        }
    }

    boolean validOperation()
    {
        return op=='+' ||
        op=='-' ||
        op=='*' ||
        op=='/' ||
        op=='%';
    }

    void calculate()
    {
        while(true)
        {
            display();
            op=s.next().toLowerCase().charAt(0);
            if(op=='q')
            {
                System.out.println("Thanks for using the calculator!");
                break;
            }
            else
            {
                if(!validOperation())
                {
                    System.out.println("Invalid operation");
                }
                else
                {
                    if(op=='h')
                    {
                        viewHistory();
                    }
                    else
                    {
                        accept();
                    if(num2==0 && (op=='/' || op=='%'))
                    {
                        System.out.println("Can't divide by zero");
                    }
                    else
                    {
                        solve();
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
