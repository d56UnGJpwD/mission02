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
        if(infix == "" || infix == " " || infix == null){
            return 0;
        }
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ')
                continue;

            else if (Character.isDigit(ch)) {
                int digit = 0;

                while (Character.isDigit(ch)) {
                    digit = digit * 10 + (int) (ch - '0');
                    i++;
                    ch = infix.charAt(i);
                }
                i--;

                stack.push(digit);
            }

            else {
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
        return stack.pop();
    }
}