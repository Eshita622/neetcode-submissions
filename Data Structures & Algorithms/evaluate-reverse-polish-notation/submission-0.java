class Solution {
    public int evalRPN(String[] tokens) {


        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            //token-> number
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                stack.push(Integer.parseInt(token));
            }

            //token -> operator
            else {
                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                }
                else if (token.equals("-")) {
                    result = a - b;
                }
                else if (token.equals("*")) {
                    result = a * b;
                }
                else if (token.equals("/")) {
                    result = a / b;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }
}
    

