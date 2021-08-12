/**
https://leetcode.com/problems/restore-ip-addresses/


Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


**/
pub struct Solution {}


impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        let bytes = s.into_bytes();
        let mut ips = vec![];
        let mut ip = vec![];
        if bytes.len() < 4 {
            return vec![]
        }
        if bytes.len() > 12 {
            return vec![];
        }

        Solution::helper(&bytes[..], &mut ip, &mut ips);
        return ips;
    }

    fn helper(bytes: &[u8], ip: &mut Vec<String>, ips: &mut Vec<String>) {
        if ip.len() == 4 {
            if bytes.is_empty() {
                if let Some(ip_str) = Solution::validate_ip(ip) {
                    ips.push(ip_str);
                }
            } else {
                return;
            }
        } else if (4- ip.len()) * 3 < bytes.len() {
            // 后续的字符的数量已经大于了ip剩余最大位数，可以直接返回了
            return;
        } else {
            let mut segment = String::new();
            for i in 0..bytes.len() {
                if i <= 3 {
                    segment.push(bytes[i] as char);
                    ip.push(segment.clone());
                    Solution::helper(&bytes[(i + 1)..], ip, ips);
                    ip.pop();
                } else {
                    break;
                }
            }
        }
    }

    fn validate_ip(ip: &Vec<String>) -> Option<String> {
        for segment in ip {
            if segment != "0" && segment.starts_with("0") {
                return None;
            } else if segment.len() > 3 {
                return None;
            } else if segment.parse::<u8>().is_err() {
                return None;
            }
        }
        return Some(format!("{}.{}.{}.{}", ip[0],ip[1],ip[2],ip[3]));
    }
}