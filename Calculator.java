
import java.util.*;

class HistoryManager {

    ArrayList<String> history = new ArrayList<>();

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

class Solver {

    int solve(ArrayList<String> SortedInput) {
        String current;
        int num1, num2, result = 0;
        ValidOp vop = new ValidOp();
        // Implementation for solving the expression
        for (int i = 0; i < SortedInput.size(); i++) {
            current = SortedInput.get(i);
            if (vop.validOperation(current.charAt(0))) {
                if (i == 1) {
                    num1 = Integer.parseInt(SortedInput.get(i - 1));
                } else {
                    num1 = result;
                }
                num2 = Integer.parseInt(SortedInput.get(i + 1));
                switch (current) {
                    case "+":
                        result = num1 + num2;
                        continue;
                    case "-":
                        result = num1 - num2;
                        continue;
                    case "*":
                        result = num1 * num2;
                        continue;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Can't divide by zero");
                            return 0;
                        }
                        result = num1 / num2;
                        continue;
                    case "%":
                        if (num2 == 0) {
                            System.out.println("Can't divide by zero");
                            return 0;
                        }
                        result = num1 % num2;
                        continue;
                    case "^":
                        result = (int) Math.pow(num1, num2);
                }
            }

        }
        return result;
    }
}

class ValidOp {

    boolean validOperation(char op) {
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
}

public class Calculator {
    // Op=operation

    int result = 0;
    char current;
    String expression = "", num = "";
    ArrayList<String> SortedInput = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    HistoryManager hm = new HistoryManager();
    Solver slv = new Solver();
    ValidOp vop = new ValidOp();

    void display() {
        System.out.println();
        System.out.println("Welcome to Calculator");
        System.out.println("Choose any of the following operations!");
        System.out.println("Enter expression");
        System.out.println();
        System.out.println("Available operations:");
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
        expression = s.next();
        SortedInput.clear();
        num = "";

        for (int i = 0; i < expression.length(); i++) {
            current = expression.charAt(i);

            if (Character.isDigit(current)) {
                num += current;
            } else if (vop.validOperation(current)) {
                SortedInput.add(num);
                SortedInput.add("" + current);
                num = "";
            }  else {
                System.out.println("Invalid expression : " + current);
                return;
            }
        }
        if (!num.isEmpty()) {
            SortedInput.add(num);
        }
    }

    void log() {
        hm.log(expression + " = " + result);
    }

    void resultDisplay() {
        System.out.println(expression + " = " + result);
    }

    void calculate() {
        while (true) {
            display();
            accept();
            switch (expression.toLowerCase().charAt(0)) {
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
                        result = slv.solve(SortedInput);
                        resultDisplay();
                        log();
                        break;
            }
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.calculate();
    }
}
