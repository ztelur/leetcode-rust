use crate::main;

/**
https://leetcode.com/problems/rotate-image/



You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Approach 1: Rotate Groups of Four Cells

对于90度的翻转有很多方法，一步或多步都可以解，先来看一种直接的方法，这种方法是按顺时针的顺序去覆盖前面的数字，从四个顶角开始，然后往中间去遍历，每次覆盖的坐标都是同理，如下：

(i, j)  <-  (n-1-j, i)  <-  (n-1-i, n-1-j)  <-  (j, n-1-i)

这其实是个循环的过程，第一个位置又覆盖了第四个位置，这里i的取值范围是 [0, n/2)，j的取值范围是 [i, n-1-i)，至于为什么i和j是这个取值范围，为啥i不用遍历 [n/2, n)，若仔细观察这些位置之间的联系，不难发现，实际上j列的范围 [i, n-1-i) 顺时针翻转 90 度，正好就是i行的 [n/2, n) 的位置，这个方法每次循环换四个数字，如下所示：



Approach 2: Reverse on Diagonal and then Reverse Left to Right

首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果，

**/

pub struct Solution {}

impl Solution {
    pub fn rotate(matrix: &mut Vec<Vec<i32>>) {
        let height = matrix.len();
        let width = matrix[0].len();

        let mut tmp;

        for i in 0..(height/2) {
            for j in 0..width {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[height - 1 - i][j];
                matrix[height - 1 - i][j] = tmp;
            }
        }

        for i in 0..height {
            for j in i..width {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}