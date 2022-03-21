package again;

import java.util.LinkedList;

class Solution {
    int ptr;

    public String decodeString(String s) {
        // 栈
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;
        // 挨个遍历
        while (ptr < s.length()) {
            // 取当前的数字
            char cur = s.charAt(ptr);
            // Character.isDigit(
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                // 在最后加上。
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr)));
                ptr ++;
            } else {
                // 说明是 ]
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                // 将【】中的字母都拷贝
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        // 将这串数字都获取到
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
