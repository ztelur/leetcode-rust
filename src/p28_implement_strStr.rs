use std::collections::HashMap;

/**
https://leetcode.com/problems/implement-strstr/

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0


Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
**/

pub struct Solution {}

impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        match (haystack.len(), needle.len()) {
            (0, 0) => return 0,
            (0, ..) => return -1,
            (.., 0) => return 0,
            _ => -1
        };


        let hay : Vec<char> = haystack.chars().collect();
        let nee : Vec<char> = needle.chars().collect();

        for i in 0..hay.len() {
            if hay[i] != nee[0] {
                continue
            }

            let mut first = i as i32;
            let mut j = i + 1;

            for k in 1..nee.len() {
                if j >= hay.len() {
                    return -1;
                }
                if hay[j] == nee[k] {
                    j += 1;
                } else {
                    first = -1;
                    break;
                }
            }

            if first != -1 {
                return first;
            }
        }
        return -1;
    }

    fn bad_character_table(pattern: &Vec<char>) -> HashMap<char, usize> {
        let mut table = HashMap::new();
        let m = pattern.len();

        for i in 0..m-1 {
            table.insert(pattern[i],m - 1 - i);
        }
        return table;
    }

    fn suffix_length_table(pattern: &Vec<char>) -> Vec<usize> {
        let m = pattern.len();

    }



    // Boyer- Moore算法
    pub fn str_str2(haystack: String, needle: String) -> i32 {

    }

    // KMP 算法
}