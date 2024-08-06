import java.util.Stack;

class Java{
    public static void main(String[] args){
        /* Leet Code Question #20
         * Easy Question #5
        */
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        if(s.length() % 2 != 0){ // if s length is not divisible by 2 return false, cause there must always be a pair to be true
            return false;
        }

        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){ // loop through each chracter in "s" String
            if(c == '(' || c == '{' || c == '['){ // push open brackets onto the stack
                stack.push(c);
            
            //If it is a corresponding closing bracket, then check if for the opening bracket, if it is pop it off, then move on
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else { // if there are only closing brackets
                return false;
            }
        }

        //if the stack is empty that means true, all valid pairs were popped and all are valid parentheses
        return stack.isEmpty();
    }
}