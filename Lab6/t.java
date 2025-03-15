package Lab6;

import java.util.*;

public class t {
    public static int checkBalance(String code) {
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < code.length(); i++) {
            if(s.isEmpty() && (code.charAt(i) == ')' || code.charAt(i) == '}' || code.charAt(i) == ']')) {
                return i;
            }
            if(s.isEmpty()) {
                if(code.charAt(i) == '(' || code.charAt(i) == '{') {
                    s.push(code.charAt(i));
                }
                else if(code.charAt(i) == ')' || code.charAt(i) == '}') {
                    return i;
                }
                else assert true;
            }
            else {
                if(code.charAt(i) == '(' || code.charAt(i) == '{') {
                    s.push(code.charAt(i));
                }
                else if(code.charAt(i) == ')') {
                    if(s.peek() == '(') {
                        s.pop();
                    }
                    else return i;
                }
                else if(code.charAt(i) == '}') {
                    if(s.peek() == '{') {
                        s.pop();
                    }
                    else return i;
                }
            }
        }   
    if(s.isEmpty()) return -1;
    else return code.length();
    }
}
