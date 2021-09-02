/**
https://leetcode.com/problems/valid-sudoku/


Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Approach 1: Hash Set

we can use hash sets to store the previously seen numbers in each row, column, and box. Via hash sets, we can determine if the current number already exists in the corresponding row, column, or box in constant time.

Time complexity: O(N^2)O(N
2Space complexity: O(N^2)O(N
2
 )


Approach 2: Array of Fixed Length

用index作为数字，表示是否已经存在

时间复杂度和空间复杂度和上边一致

Approach 3: Bitmasking

 **/



pub struct Solution {}

impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        let mut rows: [u16;9] = [0;9];
        let mut cols: [u16;9] = [0;9];
        let mut boxes: [u16;9] = [0;9];

        for i in 0..9 {
            for j in 0..9 {
                match board[i][j] {
                    '.' => continue,
                    c => {
                        let b: usize = (i / 3) * 3 + (j / 3);
                        let curr = 1 << (c.to_digit(10).unwrap());

                        if rows[i] & curr != 0 || cols[j] & curr !=0 || boxes[b] & curr != 0 {
                            return false;
                        }

                        rows[i] |= curr;
                        cols[j] |= curr;
                        boxes[b] |= curr;
                    }
                }
            }
        }
        return true;
    }
}