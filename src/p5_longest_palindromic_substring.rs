/**
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Approach 3: Dynamic Programming
To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j)P(i,j) as following:

P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\ \text{false,} &\quad\text{otherwise.} \end{cases}P(i,j)={
true,
false,
​

if the substring S
i
​
 …S
j
​
  is a palindrome
otherwise.
​


Therefore,

P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )P(i,j)=(P(i+1,j−1) and S
i
​
 ==S
j
​
 )

The base cases are:

P(i, i) = trueP(i,i)=true

P(i, i+1) = ( S_i == S_{i+1} )P(i,i+1)=(S
i
​
 ==S
i+1
​
 )

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). This gives us a runtime complexity of O(n^2)O(n
2
 ).

Space complexity : O(n^2)O(n
2
 ). It uses O(n^2)O(n
2
 ) space to store the table.

Additional Exercise

Could you improve the above space complexity further and how?


Approach 4: Expand Around Center
In fact, we could solve it in O(n^2)O(n
2
 ) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.

You might be asking why there are 2n - 12n−1 but not nn centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.

Manacher's Algorithm
这个算法是 O(n)的时间复杂度很巧妙的

https://www.zhihu.com/question/37289584
**/

pub struct Solution {}

impl Solution {
    pub fn longest_palindrome(s: String) -> String {

    }
}