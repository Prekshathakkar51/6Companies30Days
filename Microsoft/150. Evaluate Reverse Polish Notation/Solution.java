class Solution {
     public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str)) stack.push(stack.pop() + stack.pop());
            else if ("-".equals(str)) stack.push(-stack.pop() + stack.pop());
            else if ("/".equals(str)) stack.push((int)(1D / stack.pop() * stack.pop()));
            else if ("*".equals(str)) stack.push(stack.pop() * stack.pop());
            else stack.push(Integer.valueOf(str));
        }

        return stack.pop();
    }
}