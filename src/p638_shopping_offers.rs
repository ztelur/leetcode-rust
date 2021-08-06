use std::collections::HashMap;


/**
https://leetcode.com/problems/shopping-offers/

In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given an integer array price where price[i] is the price of the ith item, and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.

You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.

Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.



Example 1:

Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B.
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:

Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
Output: 11
Explanation: The price of A is $2, and $3 for B, $4 for C.
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
You cannot add more items, though only $9 for 2A ,2B and 1C.



注意审题：ou are not allowed to buy more items than you want

**/
pub struct Solution {}

impl Solution {
    pub fn shopping_offers(price: Vec<i32>, mut special: Vec<Vec<i32>>, needs: Vec<i32>) -> i32 {
        let mut cache = HashMap::new();
        cache.insert(vec![0; needs.len()], 0);

        // Remove specials that aren't actually a good deal
        // 去掉总包本身就比单价贵的special
        special.retain(|v| {
            v.last().unwrap() < &(0..price.len()).fold(0, |acc, i| acc + price[i] * v[i])
        });

        Self::go(&mut cache, &price, special.iter().collect(), needs)
    }

    fn go(
        cache: &mut HashMap<Vec<i32>, i32>,
        price: &Vec<i32>,
        special: Vec<&Vec<i32>>,
        needs: Vec<i32>,
    ) -> i32 {
        // 如果找到对应的最优解，直接返回
        if cache.contains_key(&needs) {
            *cache.get(&needs).unwrap()
        } else {
            // 先计算出need和price想乘对应的价格
            let mut min_price = (0..needs.len()).fold(0, |acc, i| acc + needs[i] * price[i]);
            // 找出所有可行的special
            let relevant_specials = special
                .iter()
                .filter(|v| (0..needs.len()).all(|i| v[i] <= needs[i]))
                .cloned()
                .collect::<Vec<&Vec<i32>>>();

            for s in &relevant_specials {
                // 想减掉
                let new_needs = (0..needs.len())
                    .map(|i| needs[i] - s[i])
                    .collect::<Vec<i32>>();
                // 然后继续遍历
                min_price = min_price.min(
                    s.last().unwrap()
                        + Self::go(cache, price, relevant_specials.clone(), new_needs),
                );
            }

            cache.insert(needs, min_price);

            min_price
        }
    }
}