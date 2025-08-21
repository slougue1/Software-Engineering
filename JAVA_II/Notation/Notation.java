
import java.util.regex.Pattern;
/**
 * This is the notation class
 * @author Sakina Lougue
 *
 */
public class Notation 
{

    static MyQueue<Character> output;
    static MyStack<Character> theStack;
    private static String[] operators = {"+", "-", "*", "/"};

    private static final String ops = "-+*/";
    private static final String operands = "0123456789";

    /**
     * This method converts an infix expression into a postfix expression
     * @param infix the infix expression in string format
     * @return the string output the postfix expression in string format
     * @throws InvalidNotationFormatException if the infix expression format is invalid
     */
    public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException 
    {
        if (infix == null || infix.length() == 0 || !checkParenthesis(infix)) 
        {
            throw new InvalidNotationFormatException("Invalid input");
        }
        output = new MyQueue<Character>(infix.length());
        theStack = new MyStack<Character>(infix.length());
        try {
            for (int index = 0; index < infix.length(); index++) {
                char aChart = infix.charAt(index);
                switch (aChart) {
                    case '+':
                    case '-':
                        gotOper(aChart, 1);
                        break; 
                    case '*': 
                    case '/':
                        gotOper(aChart, 2); 
                        break; 
                    case '(': 
                        theStack.push('('); 
                        break;
                    case ')': 
                        gotParen(aChart); 
                        break;
                    default: 
                        output.enqueue(aChart);
                        break;
                }
            }
            while (!theStack.isEmpty()) {
                output.enqueue(theStack.pop());

            }
        } catch (Exception anException) {
            System.out.println(anException);
        }
        return output.toString(); 
    }

    /**
     * This method convert the Postfix expression to the Infix expression
     * @param postfix the infix expression in string format
     * @return the string output the the infix expression in string format
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */
    public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException 
    {
        String infix = "";
        String aChar;
        String operand = "";
        String aString = "";
        
        while (postfix.indexOf(' ') >= 0) 
        {
        	postfix = postfix.replaceAll(" ", "");
        }
        
        for (int i = 0; i < postfix.length(); i++) 
        {
        	aString = aString + postfix.charAt(i) + " ";
        }
        postfix = aString.trim();

        MyStack<String> postfixStack = new MyStack<String>(postfix.length());
        MyStack<String> infixStack = new MyStack<String>(postfix.length());

        try {
            for (int i = 0; i < postfix.length(); i++) 
            {
                infixStack.push(Character.toString(postfix.charAt(i)));
            }

            while (!infixStack.isEmpty()) 
            {
                postfixStack.push(infixStack.pop());
            }

            while (!postfixStack.isEmpty()) 
            {
            	aChar = postfixStack.pop();
                if (aChar.equalsIgnoreCase("+") 
                		|| aChar.equalsIgnoreCase("-")
                        || aChar.equalsIgnoreCase("*") 
                        || aChar.equalsIgnoreCase("/")
                        || aChar.equalsIgnoreCase("%")) 
                {
                    if (!operand.isEmpty()) {
                     
                        infixStack.push(operand);
                        operand = "";
                    }
                    try {
                        String op2 = infixStack.pop();
                        String op1 = infixStack.pop();

                        if (!postfixStack.isEmpty()) 
                        {
                            String exp = "(" + op1 + aChar + op2 + ")";
                            infixStack.push(exp);
                        } 
                        else 
                        {
                            String exp = op1 + aChar + op2;
                            infixStack.push(exp);
                        }
                    }
                    catch (StackUnderflowException e) 
                    {
                        throw new InvalidNotationFormatException("\nUnable to process user entered expression"
                                + "\nERROR - Invalid postfix expression entered"
                                + "\nThe stack was cleared to allow for additional processing of expressions\n\n");
                    }
                } 
                else if (isNumber(aChar) || aChar.equals(".")) 
                {                    
                    operand += aChar;
                } 
                else if (aChar.equalsIgnoreCase(" ")) 
                {                  
                    if (!operand.isEmpty()) 
                    {                    
                        infixStack.push(operand);
                        operand = "";
                    }
                } 
                else if (Pattern.matches("[A-Za-z]", aChar.toString())) 
                {                   
                    operand += aChar;
                } 
                else 
                {                    
                	aString = ("Invalid: \"" + aChar + "\"");
                	aString += ("ERROR - unsupport value or character!");
                	aString += ("Program terminated with error");
                    throw new InvalidNotationFormatException(aString);
                }
            }
            infix = infixStack.top();
            if (infixStack.top().equals("")) 
            {
                throw new InvalidNotationFormatException("Unable to convert user entered Postfix expression: \n  \""
                        + postfix + "\"");
            } 
            else 
            {               
                while (postfix.endsWith(" ")) 
                {
                	postfix = postfix.trim();
                }
                while (infix.endsWith(" ")) 
                {
                    infix = infix.substring(0, infix.length() - 2);
                }
            }
        } 
        catch (Exception ex) 
        {
            throw new InvalidNotationFormatException(aString);
        }
        return "(" + infix + ")";
    }

    /**
     *This method valuates a postfix expression from a string to a double Parameters:
     * @param postfixExpr the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */
    public static Double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException 
    {   
        if (postfixExpr == null || postfixExpr.length() == 0) 
        {
            throw new InvalidNotationFormatException("Invalid postfix expression!");
        }
        MyStack<Double> stack = new MyStack<Double>();
        try {
            char[] aChar = postfixExpr.toCharArray();

            for (char c : aChar) 
            {
                if (isOperand(c)) 
                {
                    stack.push(new Double(c - '0')); 
                } 
                else if (isOperator(c)) 
                {
                    Double op1 = 0.0;
                    Double op2 = 0.0;
                    if (stack.isEmpty())
                    {
                        throw new InvalidNotationFormatException("Invalid format");
                    }
                    op1 = stack.pop();
                    if (stack.isEmpty()) 
                    {
                        throw new InvalidNotationFormatException("Invalid format");
                    }
                    op2 = stack.pop();
                    Double result;
                    switch (c) 
                    {
                        case '*':
                            result = op1 * op2;
                            stack.push(result);
                            break;
                        case '/':
                            result = op2 / op1;
                            stack.push(result);
                            break;
                        case '+':
                            result = op1 + op2;
                            stack.push(result);
                            break;
                        case '-':
                            result = op2 - op1;
                            stack.push(result);
                            break;
                    }
                }
            }
            return stack.pop();
        } catch (Exception ex) {
            throw new InvalidNotationFormatException("Invalid postfix expression!");
        }
        
    }

    
    /**
     * This method checks if the given string has the right parenthesis
     * @param aString
     * @return
     */
    private static boolean checkParenthesis(java.lang.String aString) 
    {
        int stack = 0;
        for (int i = 0; i < aString.length(); ++i) 
        {
            char c = aString.charAt(i);
            if (c == '(') {
                ++stack;
            } 
            else if (c == ')') 
            {
                --stack;
                if (stack < 0) 
                {
                    return false;
                }
            }
        }
        return stack == 0;
    }

    /**
     * This method returns the correct oparator from the ops list
     * @param value
     * @return
     */
    private static boolean isOperator(char value) 
    {
        return ops.indexOf(value) >= 0;
    }

    /**
     * This method returns the correct oparator from the operand list
     * @param value
     * @return
     */
    private static boolean isOperand(char value) 
    {
        return operands.indexOf(value) >= 0;
    }

    /**
     * This method returns the correct oparator from the operand list
     * @param aString
     * @return a boolean eaither true or false based the erroe catched
     */
    private static boolean isNumber(java.lang.String aString) 
    {
        try 
        {
            Integer.parseInt(aString);
            return true;
        } 
        catch (NumberFormatException numForEx) 
        {
            return false;
        }
    }

    /**
     * This method checks if the given the string has the right parenthesis
     * @param anInteger
     * @param operands1
     * @throws StackUnderflowException,QueueOverflowException,StackOverflowException
     */
    private static void gotOper(char operands1, int anInteger) throws StackUnderflowException, 
                                                                       QueueOverflowException, 
                                                                        StackOverflowException 
    {
        while (!theStack.isEmpty()) {
            char opTop = ((String) (theStack.pop() + "")).charAt(0);
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            }
            else 
            {
                int anInteger1;
                if (opTop == '+' || opTop == '-') 
                {
                	anInteger1 = 1;
                } 
                else 
                {
                	anInteger1 = 2;
                }
                if (anInteger1 < anInteger) 
                { 
                    theStack.push(opTop); 
                    break; // what the loop end right here
                } 
                else 
                {
                    output.enqueue(opTop); 
                }
            }
        }
        theStack.push(operands1);
    }

    /**
     * This method checks the letter of the sting
     * @param anInteger
     * @throws StackUnderflowException, QueueOverflowException
     */
    private static void gotParen(char aChar) throws StackUnderflowException,
                                                    QueueOverflowException 
    {
        while (!theStack.isEmpty()) 
        {
            char aChar1 = ((String) (theStack.pop() + "")).charAt(0);
            if (aChar1 == '(') 
            {
                break;
            }
            else 
            {
                output.enqueue(aChar1);
            }
        }
    }

    /**
     * This method checks the operator
     * @param aString
     * @return index 
     */
    private int operator(java.lang.String aString) {
        for (int index = 0; index < operators.length; index++) 
        {
            if (aString.equals(operators[index])) 
            {
                return index;
            }
        }
        return operators.length;
    }

}
