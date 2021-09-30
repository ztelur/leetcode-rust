use std::collections::HashMap;

/**
https://leetcode.com/problems/substring-with-concatenation-of-all-words/


You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.



Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]


Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.





**/

pub struct Solution {}

struct Term {
    expect: i32,
    count: i32,
}

impl Term {
    fn new(expect: i32, count: i32) -> Self {
        Term {expect, count}
    }

    fn inc_expect(&mut self) {
        self.expect += 1;
    }

    fn inc(&mut self) {
        self.count += 1;
    }

    fn dec(&mut self) {
        self.count -= 1;
    }

    fn exhausted(&self) -> bool {
        self.count > self.expect;
    }

    fn reset(&mut self) {
        self.count = 0;
    }


}


impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        if words.len() < 1 {
            return vec![];
        }

        let word_len = words[0].len();
        if word_len < 1 {
            return vec![];
        }

        let substr_len = word_len * words.len();

        let mut map: HashMap<&str, Term> = HashMap::with_capacity(words.len());

        for word in words.iter() {
            map.entry(word).or_insert(Term::new(0,0)).inc_expect();
        }

        let mut result: Vec<i32> = Vec::new();
        // we can split terms in N ways, where N = word_len
        for shift in 0..word_len {
            let mut i = shift;
            let mut j = shift;

            while
        }

    }
}