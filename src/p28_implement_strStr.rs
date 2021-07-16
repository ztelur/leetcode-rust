use std::collections::HashMap;
use std::cmp::max;

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
        let (mut f, mut g) = (0usize, m-1);
        let mut table = vec![m;m];

        for i in (0..m-2).rev() {
            if i > g && table[i + m -1 - f] < i - g {
                talbe[i] = table[i + m - 1 - f];
                continue
            }

            if i < g {
                g = i;
            }
            f = i;

            table[i] = (0..=i).rev().take_while(|&j|pattern[j] == pattern[m-1-i+j]).count()
        }
        return table;
    }

    fn good_suffix_table(pattern: &Vec<char>) -> Vec<usize> {
        let m = pattern.len();
        let mut table = vec![m;m];
        let suffix = suffix_length_table(pattern);

        let mut last_prefix_position = m;
        for i in (1..m).rev() {
            if suffix[m-1-i] == m - i {
                last_prefix_position = i;
            }
            table[m-i] = last_prefix_position - i + m;
        }
        (0..m-1).for_each(|i| table[suffix[i]] = m -1 -i + suffix[i]);
        return table;
    }

    fn boyer_moore(text: Vec<char>, pattern: Vec<char>) -> i32 {
        let m = pattern.len();
        let end = text.len();

        let char_table = bad_character_table(&pattern);
        let offset_table = good_suffix_table(&pattern);

        let mut i = m -1;
        while i < end {
            let matches = (0..m).rev()
                .take_while(|&j|pattern[j] == text[i- (m - 1 - j)]).count();
            i -= matches;
            if matches == m {
                return i as i32 + 1;
            }

            i += max(
                offset_table[matches],
                *char_table[&text[i]] // todo
            )
        }
        return -1;
    }

    // Boyer- Moore算法 https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
    pub fn str_str2(haystack: String, needle: String) -> i32 {
        if needle.is_empty() {
            0
        } else {
            boyer_moore(haystack.chars().collect(), needle.chars().collect())
        }
    }

    // KMP 算法
}