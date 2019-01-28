package edu.isu.cs.cs3308;


import edu.isu.cs.cs3308.structures.impl.LinkedStack;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     *                each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {

        //Initial check for illegal inputs
        if(infix == "" || infix == " " || infix == null){
            return 0;
        }
        //create the stack that will be used
        LinkedStack<Integer> stack = new LinkedStack<>();

        //parse the input string at every space
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ')
                continue;

            //loop while we are looking at a digit, and not a space(for numbers > 9)
            else if (Character.isDigit(ch)) {
                int digit = 0;

                while (Character.isDigit(ch)) {
                    digit = digit * 10 + (int) (ch - '0');
                    i++;
                    ch = infix.charAt(i);
                }
                i--;
            //add the number to our stack
                stack.push(digit);
            }

            else {
                //try catch to see if there are enough numbers/operators to complete the calculation
                try {
                    int n1 = stack.pop();
                    int n2 = stack.pop();


                    switch (ch) {
                        case '+':
                            stack.push(n2 + n1);
                            break;

                        case '-':
                            stack.push(n2 - n1);
                            break;

                        case '/':
                            stack.push(n2 / n1);
                            break;

                        case '*':
                            stack.push(n2 * n1);
                            break;
                    }
                }
                catch(Exception e){
                    throw new IllegalArgumentException();
                }
            }
        }
        //return the calculated number
        return stack.pop();
    }
}