In the first method take 2 stacks
Push
1. pop all the elements from s1 and push in s2
2. push the incoming element in s1
3. pop all the elements again from s2 and push in s1
Pop
pop the topmost element from the s1
​
Amortized method (Sometimes `O(n)`) but overall `O(1)`
Take 2 stacks input and output
in push operations simply push in input
POp
if(output is empty) pop all elements from s1 and push in s2
than pop from output
else pop from output
​
Top
Same as pop