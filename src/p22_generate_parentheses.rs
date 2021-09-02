/**
https://leetcode.com/problems/generate-parentheses/


Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Input: n =2
Output: ["()()", "(())"]



Constraints:

1 <= n <= 8


backtracking, dp


choices 对于每一个数字我们可以有3个或4个字母选择，例如输入为”23“时，我们的字母组合为两个。我们将此看作有两个空位去填，第一个空位我们的选择有”abc"，第二个空位选择有“def"
constraint 对于每一个空位我们并没有特殊的限制阻碍我们做选择，所以对于此题，没有constraint。
goal: 此题的goal是当我们读完输入的字符串时，就结束了，因为在读字符串的时候，我们同时在考虑所有的组合，当字符串读完时，问题也就求解完了。



choices 毫无疑问，在一共2*n (e.g. 6 个) 空位中选择 “(” 或者 “)”
constraint 这一问题中是有constraint 的，首先，我们一共可以选填n次左括号和n次右括号，左右括号必须封闭。 总结来说，我们把限制分为左括号和右括号的限制。对于左括号，只要可以选填n 次的左括号还有剩余，就可以填左括号。对于右括号，如果还没有填的左括号数量少于还没有填的右括号的数目就可以填右括号（比如还剩1 个左括号剩余，和2 个右括号剩余，说明组合中有左括号没有被封闭，可以填右括号）
goal 当填了2*n个括号后，问题结束

回溯算法说白了就是穷举法。不过回溯算法使用剪枝函数，剪去一些不可能到达最终状态（即答案状态）的节点，从而减少状态空间树节点的生成。
回溯法是一个既带有系统性又带有跳跃性的的搜索算法。它在包含问题的所有解的解空间树中，按照深度优先的策略，从根结点出发搜索解空间树。算法搜索至解空间树的任一结点时，总是先判断该结点是否肯定不包含问题的解。如果肯定不包含，则跳过对以该结点为根的子树的系统搜索，逐层向其祖先结点回溯。否则，进入该子树，继续按深度优先的策略进行搜索。

回溯法在用来求问题的所有解时，要回溯到根，且根结点的所有子树都已被搜索遍才结束。
而回溯法在用来求问题的任一解时，只要搜索到问题的一个解就可以结束。
这种以深度优先的方式系统地搜索问题的解的算法称为回溯法，它适用于解一些组合数较大的问题。

**/

pub struct Solution{}

impl Solution {

    // impl Solution {
    //     fn helper(res: &mut Vec<String>, par: String, n: i32, m: i32) {
    //         if n == 0 && m == 0 {
    //             res.push(par);
    //             return;
    //         }
    //
    //         if n > 0 {
    //             Self::helper(res, par.clone() + &"(", n-1, m + 1);
    //         }
    //
    //         if m > 0 {
    //             Self::helper(res, par.clone() + &")", n, m -1);
    //         }
    //     }
    //
    //     pub fn generate_parenthesis(n: i32) -> Vec<String> {
    //         let mut res: Vec<String> = Vec::new();
    //         Self::helper(&mut res, String::from(""), n , 0);
    //         return res;
    //     }
    // }

    pub fn generate_parenthesis2(n: i32) -> Vec<String> {
        fn back_track(s: String, open: i32, close: i32) -> Vec<String> {
            let mut res = vec![];
            if open == 0 && close == 0 {
                return vec![s];
            }
            if open > 0 {
                res.append(&mut back_track(s.clone()+"(", open-1, close+1));
            }
            if close > 0 {
                res.append(&mut back_track(s.clone()+")", open, close-1));
            }
            res
        }
        back_track("".to_string(), n, 0)
    }

    pub fn generate_parenthesis_dp(n: i32) -> Vec<String> {
        let n = n as usize;
        let mut dp = vec![vec![vec![]; n + 1]; n + 1];
        dp[0][0].push(String::new());

        for i in 0..=n {
            for j in 0..=i {
                if i == n && j == i {
                    return dp[i].pop().unwrap()
                }

                while let Some(s) = dp[i][j].pop() {
                    if i < n {
                        dp[i + 1][j].push(s.clone() + "(");
                    }
                    if i > j {
                        dp[i][j + 1].push(s + ")");
                    }
                }
            }
        }

        vec![]
    }
}