/**
https://leetcode.com/problems/permutations-ii/

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

46是无脑进行backtrack,但是这里有了重复的数字，比如1,1,2，那么第一个位置选第一个1和第一个位置选第二个1其实是一样的，
导致不能无脑进行backtrack


First of all, let us review the general idea of permutation with an example.

Given the input array [1, 1, 2], to generate a permutation of the array, we could follow the Depth-First Search (DFS) approach, or more precisely the backtracking technique as one will see later.

The idea is that we pick the numbers one by one. For a permutation of length NN, we would then need NN stages to generate a valid permutation. At each stage, we need to pick one number into the permutation, out of the remaining available numbers. Later at the same stage, we will try out all available choices. By trying out, we progressively build up candidates to the solution, and revert each choice with another alternative until there is no more choice.




Let us walk through the example with paper and pencil, as follows:

Given the input of [1, 1, 2], at the first stage, we have 2 choices to pick a number as the first number in the final permutation, i.e. 1 and 2. Suppose that we pick the number 1, now the remaining numbers would become [1, 2]. Note: The reason that we have only 2 choices instead of 3, is that there is a duplicate in the given input. Picking any of the duplicate numbers as the first number of the permutation would lead us to the same permutation at the end. Should the numbers in the array be all unique, we would then have the same number of choices as the length of the array.

At the second stage, we now then have again 2 choices, i.e. [1, 2]. Let us pick again the number 1, which leaves us the only remaining number 2.

Now at the third stage, we have only one candidate number left, i.e. [2]. We then pick the last remaining number, which leads to a final permutation sequence of [1, 1, 2].

Moreover, we need to revisit each of the above stages, and make a different choice in order to try out all possibilities. The reversion of the choices is what we call backtracking.




A key insight to avoid generating any redundant permutation is that at each step rather than viewing each number as a candidate, we consider each unique number as the true candidate. For instance, at the very beginning, given in the input of [1, 1, 2], we have only two true candidates instead of three.



 **/
pub struct Solution {}

impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        fn backtrack(nums: &[i32], cur: &[i32], res: &mut Vec<Vec<i32>>) {
            if nums.len() == 0 {
                res.push(cur.to_vec());
                return;
            }

            for (i, v) in nums.iter().enumerate() {
                // 排序后，可以保证相同的num只取一个
                if i == 0 || nums[i] != nums[i - 1] {
                    let (mut nums_c, mut cur_c) = (nums.to_vec(), cur.to_vec());

                }
            }


        }

        nums.sort_unstable();
    }
}