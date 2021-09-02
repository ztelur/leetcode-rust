/**
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

hashtable string backtracking

一、自己的思路

先将数字转换为对应的字母，然后字母乘起来

比如 23

2 -> [a,b,c]
3 -> [d,e,f]

所以就是 ad ae af bd be bf cd ce cf

二、copy 思路


**/

pub struct Solution {}

impl Solution {
    fn get_char(c: char) -> String {
        let mut res = "";
        if c == '2' {
            res = "abc";
        } else if c == '3' {
            res = "def";
        } else if c == '4' {
            res = "ghi";
        } else if c == '5' {
            res = "jkl"
        } else if c == '6' {
            res = "mno";
        } else if c == '7' {
            res = "pqrs";
        } else if c == '8' {
            res = "tuv";
        } else if c == '9' {
            res = "wxyz";
        }
        return res.into();
    }


    pub fn letter_combinations(digits: String) -> Vec<String> {
        if digits.is_empty() {
            return vec![];
        }
        digits.chars().fold(vec![String::from("")],
                |acc, digit| acc.iter().flat_map(
                    |x| Self::get_char(digit).chars().map(
                        |y| format!("{}{}", x, y)
                    ).collect::<Vec<String>>()
                ).collect()
        )
    }



    pub fn letter_combinations_bt(digits: String) -> Vec<String> {
        if digits.is_empty() {
            return vec![];
        }

        let mut num_to_letter = vec!["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];

        fn combs(out: &mut Vec<String>, cur: &mut Vec<char>, digits: &str, num_to_letter: &Vec<&str>) {
            match digits.chars().next() {
                None => out.push(cur.iter().collect()),
                Some(c) => {
                    for letter in num_to_letter[c.to_digit(10).unwrap() as usize].chars() {
                        cur.push(letter);
                        combs(out, cur, &digits[1..],num_to_letter);
                        cur.pop();
                    }
                }
            }
        }

        let mut out: Vec<String> = vec![];
        let mut cur: Vec<char> = vec![];
        combs(&mut out,&mut cur,&digits, &num_to_letter);
        return out;
    }


    }