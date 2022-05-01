package com.glearning.pg.client;
import java.util.*;

	// Question - 1) Write a program of Balancing Brackets, use a suitable data structure to 
	//				print whether the string entered is a Balanced Brackets or Unbalanced String

public class BalancingBrackets {
	
	// Method to verify if brackets are balanced
    static boolean chkBracketsBalanced(String inputString)
    {
        Deque<Character> stack = new ArrayDeque<Character>();
  
        // Traversing the Expression
        for (int i = 0; i < inputString.length(); i++) 
        {
            char x = inputString.charAt(i);
            if (x == '(' || x == '[' || x == '{') 
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
  
            if (stack.isEmpty())
                return false;
            
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
  
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
  
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return (stack.isEmpty());
    }
  
    // main function - Driver code
    /* 
	   	Sample inputs 
	 	1. ([{}]) or ( [ [ { } ] ] )
	 	2. ([[{}]])) or ( [ [ { } ] ] ) )
	*/
    public static void main(String[] args)
    {
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Provide the string to verify Balancing Brackets: ");
        String inputString = scanner.nextLine().replaceAll("\\s", "");;
        
        // verify if the string contains odd number of characters
        int chkLength = (inputString.toCharArray().length) % 2;
        
        // if the string contains odd number of characters then it does not contain Balanced Brackets 
        if(chkLength==0) {
        	if (chkBracketsBalanced(inputString))
                System.out.println(" The entered String has Balanced Brackets");
            else
                System.out.println("The entered String does not contain Balanced Brackets");
        }
        else {
        	System.out.println("The entered String does not contain Balanced Brackets");
        }
       
        scanner.close();
      }

}
