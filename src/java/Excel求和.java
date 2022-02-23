/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 *
 * @author libing
 * @version $Id: Excel求和.java, v 0.1 2022年02月23日 下午3:33 zt Exp $
 */
class Solution {
    public int titleToNumber(String columnTitle) {

        int len = columnTitle.length();
        if (len == 0) {
            return 0;
        }

        int sum = 0;
        // A A len = 2
        for (int i = 0; i < len; i ++) {
            sum += (columnTitle.charAt(i) - 'A') * (26 ^ (len - i - 1));
        }
        return sum;
    }
}