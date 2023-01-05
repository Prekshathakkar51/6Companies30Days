# Evaluate Reverse Polish Notation
## Description

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

## Note that:

-The valid operators are '+', '-', '*', and '/'.
-Each operand may be an integer or another expression.
-The division between two integers always truncates toward zero.
-There will not be any division by zero.
-The input represents a valid arithmetic expression in a reverse polish notation.
-The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:
```
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```
Example 2:
```
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```
Example 3:
```
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```


# Intuition
Think it like when u get any operator (+,-,*,/) the you consider teh previous 2 values and perform that operation on those and give the result
So you have to first hunt for the operator, once you find it, pick the previous 2 values and do the operation

## Example : 2 3 + ==> (2+3) = 5

So here when you hunt for operator, you get + and then operate it on the previous two value i.e 2 and 3 and give the result i.e 5

So we can use here Stack Data Structure, pretty suitable!

The top element if(+,-,*,/) then perform the operation on the previous 2 elements and pop them out while push the result in!

Pretty Simple!!

# Approach
Step 1: Initialize the stack
Step 2: Run a for loop in which it takes the value of each token of the string entered
Step 3: push all the elements in the stack until you get any operator +,-,*,/ in the stack as the top element
Step 4: Once you get any of these operators as the top element then, do that operation on the previous 2 values entered in the stack,pop both those value and push the result in the stack
Step 5: Do Step 4 untill you complete with all the operators and pop the final result

# Complexity
## Time complexity:
O(n^2)

## Space complexity:
O(n)
