/**
https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.



典型的跟 p36_valid_sudoku 关联的，第一遍先扫描，生成对应的数据，然后第二遍使用 backtracing

**/
use std::char;

// https://leetcode.com/problems/sudoku-solver/discuss/1130907/Rust-backtracking
impl Solution {
    pub fn solve_sudoku(board: &mut Vec<Vec<char>>) {
        Self::backtracking(board, (0, 0));
    }

    fn backtracking(board: &mut Vec<Vec<char>>, pos: (usize, usize)) -> bool {
        let (x, y) = pos;
        if board[x][y] != '.' {
            if let Some(next_pos) = Self::next_pos(pos) {
                return Self::backtracking(board, next_pos);
            } else {
                return true;
            }
        }

        let mut options = vec![true; 9];
        for i in 0..9 {
            if let Some(digit) = board[i][y].to_digit(10) {
                options[digit as usize - 1] = false;
            }
            if let Some(digit) = board[x][i].to_digit(10) {
                options[digit as usize - 1] = false;
            }
        }
        for i in (x / 3 * 3)..=(x / 3 * 3 + 2) {
            for j in (y / 3 * 3)..=(y / 3 * 3 + 2) {
                if let Some(digit) = board[i][j].to_digit(10) {
                    options[digit as usize - 1] = false;
                }
            }
        }
        for i in 0..9 {
            if !options[i] { continue; }
            board[x][y] = std::char::from_digit((i + 1) as u32, 10).unwrap();
            if let Some(next_pos) = Self::next_pos(pos) {
                let res = Self::backtracking(board, next_pos);
                if res {
                    return true;
                }
            } else {
                return true;
            }
        }
        board[x][y] = '.';
        false
    }

    fn next_pos(pos: (usize, usize)) -> Option<(usize, usize)> {
        if pos.1 < 8 {
            Some((pos.0, pos.1 + 1))
        } else if pos.0 < 8 {
            Some((pos.0 + 1, 0))
        } else {
            None
        }
    }
}


pub struct Solution {}

// impl Solution {
//     pub fn solve_sudoku(board: &mut Vec<Vec<char>>) {
//
//         let mut rows:[u16; 9] = [0;9];
//         let mut cols:[u16; 9] = [0;9];
//         let mut boxes:[u16; 9] = [0;9];
//
//         for i in 0..9 {
//             for j in 0..9 {
//
//                 match board[i][j] {
//                     '.' => continue,
//                     c => {
//                         let b = (i / 3) * 3 + j / 3;
//                         let curr = 1 << (c.to_digit(10).unwrap());
//
//                         // 无需校验正确性，直接取并
//                         rows[i] |= curr;
//                         cols[j] |= curr;
//                         boxes[b] |= curr;
//                     }
//                 }
//             }
//         }
//         Self::backtrace(board, 0, 0, &mut rows, &mut cols, &mut boxes);
//         return;
//         // backtraceing
//     }
//
//
//     fn backtrace(board: &mut Vec<Vec<char>>, curI: usize, curJ: usize, rows: &mut[u16;9], cols: &mut[u16;9], boxes: &mut[u16;9]) -> bool {
//         if curI  == 9 {
//             return true;
//         }
//
//         for i in curI..9 {
//             for j in curJ..9 {
//
//                 if board[i][j] != '.' {
//                     continue;
//                 }
//
//                 let optioanl_num = Self::optional(i, j, rows, cols, boxes);
//                 if optioanl_num.is_empty() {
//                     return false;
//                 }
//                 for m in optioanl_num {
//                     let b = (i / 3) * 3 + j / 3;
//
//                     let curr = 1 << (m.to_digit(10).unwrap());
//                     board[i][j] = m;
//                     rows[i] |= curr;
//                     cols[j] |= curr;
//                     boxes[b] |= curr;
//
//                     let mut ret = false;
//                     if j == 8 {
//                         ret = Self::backtrace(board, i, 0, rows, cols, boxes);
//                     } else {
//                         ret = Self::backtrace(board, i + 1, j, rows, cols, boxes);
//                     }
//
//                     if ret {
//                         return true;
//                     }
//
//                     rows[i] ^= curr;
//                     cols[j] ^= curr;
//                     boxes[b] ^= curr;
//                 }
//             }
//         }
//         return false;
//     }
//
//     fn optional(i: usize, j: usize, rows: &mut[u16;9], cols: &mut[u16;9], boxes: &mut[u16;9]) -> Vec<char> {
//         let mut res = vec![];
//         for num in 0..9 {
//             let b = (i / 3) * 3 + j / 3;
//             let curr = 1 << num;
//
//             if rows[i] & curr != 0 || cols[j] & curr !=0 || boxes[b] & curr != 0 {
//                 continue;
//             }
//             res.push(char::from_digit(num, 10).unwrap());
//         }
//         return res;
//     }
//
// }


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn two_sum_test() {
        let mut v = vec![
            vec!['5','3','.','.','7','.','.','.','.'],
            vec!['6','.','.','1','9','5','.','.','.'],
            vec!['.','9','8','.','.','.','.','6','.'],
            vec!['8','.','.','.','6','.','.','.','3'],
            vec!['4','.','.','8','.','3','.','.','1'],
            vec!['7','.','.','.','2','.','.','.','6'],
            vec!['.','6','.','.','.','.','2','8','.'],
            vec!['.','.','.','4','1','9','.','.','5'],
            vec!['.','.','.','.','8','.','.','7','9']];
        Solution::solve_sudoku(&mut v);
        println!("{:?}", v);
    }
}
