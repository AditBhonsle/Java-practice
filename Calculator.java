
import java.util.*;

class historyManager {

    ArrayList<String> history = new ArrayList<String>();

    void log(String entry) {
        history.add(entry);
    }

    void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No history found");
            return;
        }
        System.out.println("History:");
        for (String s : history) {
            System.out.println(s);
        }
    }

    void clearHistory() {
        if (history.isEmpty()) {
            System.out.println("History is already empty");
            return;
        }
        history.clear();
        System.out.println("History cleared");
    }
}

class solver {

    int result = 0;

    int solve(int num1, int num2, char op) {
        switch (op) {
            case '+':
                result = num1 + num2;
                return result;
            case '-':
                result = num1 - num2;
                return result;
            case '*':
                result = num1 * num2;
                return result;
            case '/':
                result = num1 / num2;
                return result;
            case '%':
                result = num1 % num2;
                return result;
            case '^':
                result = (int) Math.pow(num1, num2);
                return result;

        }
        return 0;
    }
}

public class Calculator {

    char op;                        // Op=operation
    int num1, num2, result = 0;
    Scanner s = new Scanner(System.in);
    historyManager hm = new historyManager();
    solver slv = new solver();

    void display() {
        System.out.println();
        System.out.println("Welcome to Calculator");
        System.out.println("Choose any of the following operations!");
        System.out.println("+ (Addition)");
        System.out.println("- (Subtraction)");
        System.out.println("* (Multiplication)");
        System.out.println("/ (Division)");
        System.out.println("% (Remainder)");
        System.out.println("^ (Power)");
        System.out.println("H (History)");
        System.out.println("C (Clear history)");
        System.out.println("Q (Exit the calculator)");
    }

    void accept() {
        System.out.println("Enter number 1");
        num1 = s.nextInt();
        System.out.println("Enter number 2");
        num2 = s.nextInt();
    }

    void log() {
        hm.log(num1 + " " + op + " " + num2 + " = " + result);
    }

    void resultDisplay() {
        System.out.println(num1 + " " + op + " " + num2 + " = " + result);
    }

    boolean validOperation() {
        return op == '+'
                || op == '-'
                || op == '*'
                || op == '/'
                || op == '%'
                || op == '^'
                || op == 'h'
                || op == 'c'
                || op == 'q';
    }

    void calculate() {
        while (true) {
            display();
            op = s.next().toLowerCase().charAt(0);
            if (!validOperation()) {
                System.out.println("Invalid operation");
                continue;
            }
            switch (op) {
                case 'q':
                    System.out.println("Thanks for using the calculator!");
                    return;
                case 'h':
                    hm.displayHistory();
                    continue;
                case 'c':
                    hm.clearHistory();
                    continue;
                default:
                    accept();
                    if (num2 == 0 && (op == '/' || op == '%')) {
                        System.out.println("Can't divide by zero");
                    } else {
                        result = slv.solve(num1, num2, op);
                        resultDisplay();
                        log();
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.calculate();
    }
}
