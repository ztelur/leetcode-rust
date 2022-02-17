/**

https://leetcode.com/problems/count-and-say/

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.



Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"


https://leetcode-cn.com/problems/count-and-say/solution/wai-guan-shu-lie-by-leetcode-solution-9rt8/
**/

pub struct Solution {}

impl Solution {
    pub fn count_and_say(n: i32) -> String {
        if n == 1 {
            return "1".to_string();
        }

        let prev_res = Self::count_and_say(n - 1).chars().collect::<Vec<char>>();
        let mut res = vec![];

        let mut prev_char = &prev_res[0];
        let mut count = 1;

        for chr in &prev_res[1..] {
            if chr == prev_char {
                count += 1;
            } else {
                res.push(format!("{}{}", count, prev_char));
                count += 1;
            }
        }
        res.push(format!("{}{}",count, prev_char));
        return res.join("");
    }
}