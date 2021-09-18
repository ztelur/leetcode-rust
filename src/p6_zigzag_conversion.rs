/**
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000


之字型


PAYPALISHIRING

P   A   H   N
A P L S I I G
Y   I   R

PAYPALISHIR I N G
012345678910111213
P A H N
APLSIIG
Y I R

PAHNAPLSIIGYIR
PAHN  APLSII G  YI R
04812 135791112 26 10

3 行则第一行间隔 4，第二行间隔 2 第三行间隔 4


Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I


4行，第一行间隔6
第二行间隔 1 -》 5-》7-》11
 间隔 4 和 2



第三行分别间隔 2 4
第四行间隔是6


PAYPALISHIRING numsRow = 5;

P        H

A      S  I

Y    I     R

P  L        I  G

A            N


第一行是 (n-t) * 2
第二行间隔 (n-t) * 2  2 * (t-1)
第三章间隔 (n-t) * 2  2 * (t-1);
第四行间隔 (n-t) * 2  2 * (t-1);
第五行间隔 (n-t) * 2 2 * (t-1);



**/

pub struct Solution {}

impl Solution {
    // 实际演算法，就是给一个string列表，然后按照之字去加，加完之后，将这些string拼接起来
    pub fn convert(s: String, num_rows: i32) -> String {
        let nums_row = num_rows as usize;

        if nums_row < 2 {
            return s;
        }

        let mut newS = vec![String::new(); nums_row];

        let mut i = 0;
        let mut down = true;

        for c in s.chars() {
            newS[i].push(c);
            i = if down { i + 1 } else {i - 1};
            down = down == ( i > 0 && i < nums_row - 1);
        }
        return newS.concat();
    }

    pub fn convert2(s: String, num_rows: i32) -> String {
        let mut newS = String::new();


        let mut index = 1;
        for i in 1..num_rows + 1 {
            newS.push(s[]);

        }


    }

}